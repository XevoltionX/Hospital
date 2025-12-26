package top.hepingan.java.service;

import top.hepingan.java.entity.Tea;
import top.hepingan.java.entity.dto.TeaDto;
import top.hepingan.java.entity.dto.TeaImgDto;
import top.hepingan.java.entity.vo.TeaVo;

import java.util.List;

public interface TeaService {
    List<TeaVo> teaList(String teaName, String category, String sort);

    List<TeaVo> hotList();

    void add(TeaDto teaDto);

    void updateImg(TeaImgDto teaImgDto);

    void deleteImg(TeaImgDto teaImgDto);

    void update(TeaDto teaDto);

    void delete(Integer teaId);
}
