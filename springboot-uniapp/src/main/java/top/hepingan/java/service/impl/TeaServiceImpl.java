package top.hepingan.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.hepingan.java.entity.Tea;
import top.hepingan.java.entity.TeaImages;
import top.hepingan.java.entity.dto.TeaDto;
import top.hepingan.java.entity.dto.TeaImgDto;
import top.hepingan.java.entity.vo.TeaVo;
import top.hepingan.java.mapper.TeaImagesMapper;
import top.hepingan.java.mapper.TeaMapper;
import top.hepingan.java.service.TeaService;
import top.hepingan.java.utils.AliUploadUtils;
import top.hepingan.java.utils.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeaServiceImpl implements TeaService {

    private final TeaMapper teaMapper;
    private final TeaImagesMapper teaImagesMapper;
    private final AliUploadUtils aliUploadUtils;

    /**
     * 获取茶列表
     * @param teaName
     * @param category
     * @param sort
     * @return
     */
    @Override
    public List<TeaVo> teaList(String teaName, String category, String sort) {
        LambdaQueryWrapper<Tea> lambda = new QueryWrapper<Tea>().lambda()
                .orderByDesc(Tea::getCreatedTime);
        if (teaName != null && !teaName.equals("")) {
            lambda.like(Tea::getTeaName, teaName);
        }
        if (category != null && !category.equals("")) {
            lambda.eq(Tea::getCategory, category);
        }
        if (sort != null && !sort.equals("")) {
            if (sort.equals("highPrice")) {
                lambda.orderByDesc(Tea::getPrice);
            } else if (sort.equals("bottomPrice")) {
                lambda.orderByDesc(Tea::getDiscountPrice);
            }
        }
        List<Tea> teas = teaMapper.selectList(lambda);
        return getTeaVos(teas);
    }

    /**
     * 获取热销列表
     * @return
     */
    @Override
    public List<TeaVo> hotList() {
        List<Tea> teas = teaMapper.selectList(new QueryWrapper<Tea>().lambda()
                .eq(Tea::getIsHot, true)
                .orderByDesc(Tea::getCreatedTime)
                .last("LIMIT 8"));
        return getTeaVos(teas);
    }

    /**
     * 添加茶
     * @param teaDto
     */
    @Override
    public void add(TeaDto teaDto) {
        if (teaMapper.selectById(teaDto.getTeaId()) != null){
            //更新
            Tea tea = BeanUtils.copyClassProperTies(teaDto, Tea.class);
            teaMapper.updateById(tea);
        }else {
            //添加
            Tea tea = BeanUtils.copyClassProperTies(teaDto, Tea.class);
            teaMapper.insert(tea.setCreatedTime(LocalDateTime.now()));
            for (MultipartFile imgUrl : teaDto.getImageList()){
                String originalFileName = imgUrl.getOriginalFilename();
                String fileExtension = originalFileName != null ? originalFileName.substring(originalFileName.lastIndexOf(".")) : "";
                String tea1 = aliUploadUtils.uploadFile(imgUrl, "tea", UUID.randomUUID() + "." + fileExtension, true);
                teaImagesMapper.insert(new TeaImages().setImgUrl(tea1).setTeaId(tea.getTeaId()));
            }
        }

    }

    /**
     * 添加图片
     * @param teaImgDto
     */
    @Override
    public void updateImg(TeaImgDto teaImgDto) {
        String originalFileName = teaImgDto.getImage().getOriginalFilename();
        String fileExtension = originalFileName != null ? originalFileName.substring(originalFileName.lastIndexOf(".")) : "";
        String imgUrl = aliUploadUtils.uploadFile(teaImgDto.getImage(), "tea", UUID.randomUUID() + "." + fileExtension, true);
        teaImagesMapper.insert(new TeaImages()
                .setImgUrl(imgUrl)
                .setTeaId(teaImgDto.getTeaId()));
    }

    /**
     * 删除图片
     * @param teaImgDto
     */
    @Override
    public void deleteImg(TeaImgDto teaImgDto) {
        aliUploadUtils.deleteFile(teaImgDto.getImgUrl());
        teaImagesMapper.delete(new QueryWrapper<TeaImages>().lambda().eq(TeaImages::getImgUrl, teaImgDto.getImgUrl()));
    }

    /**
     * 修改茶
     * @param teaDto
     */
    @Override
    public void update(TeaDto teaDto) {
        Tea tea = BeanUtils.copyClassProperTies(teaDto, Tea.class);
        tea.setUpdatedTime(LocalDateTime.now());
        teaMapper.updateById(tea);
    }

    /**
     * 删除茶
     * @param teaId
     */
    @Override
    public void delete(Integer teaId) {
        teaMapper.deleteById(teaId);
        List<TeaImages> teaImages = teaImagesMapper.selectList(new QueryWrapper<TeaImages>().lambda()
                .eq(TeaImages::getTeaId, teaId));
        for (TeaImages teaImage : teaImages){
            aliUploadUtils.deleteFile(teaImage.getImgUrl());
        }
        teaImagesMapper.delete(new QueryWrapper<TeaImages>().lambda()
                .eq(TeaImages::getTeaId, teaId));
    }

    private List<TeaVo> getTeaVos(List<Tea> teas) {
        List<TeaVo> teaVos = new ArrayList<>();
        for (Tea tea : teas){
            TeaVo teaVo = BeanUtils.copyClassProperTies(tea, TeaVo.class);
            List<String> imageList = teaImagesMapper.selectList(new QueryWrapper<TeaImages>().lambda()
                            .eq(TeaImages::getTeaId, tea.getTeaId())).stream()
                    .map(TeaImages::getImgUrl)
                    .toList();
            teaVo.setImageList(imageList);
            teaVos.add(teaVo);
        }
        return teaVos;
    }
}
