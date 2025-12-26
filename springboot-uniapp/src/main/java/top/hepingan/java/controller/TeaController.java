package top.hepingan.java.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.hepingan.java.common.Result;
import top.hepingan.java.entity.dto.TeaDto;
import top.hepingan.java.entity.dto.TeaImgDto;
import top.hepingan.java.service.TeaService;

@RequiredArgsConstructor
@RequestMapping("/tea")
@RestController
@Slf4j
public class TeaController {

    private final TeaService teaService;

    @GetMapping("/list")
    public Result list(@RequestParam String teaName,
                        @RequestParam String category,
                        @RequestParam String sort) {
        return Result.data(teaService.teaList( teaName, category, sort));
    }

    @GetMapping("/hotList")
    public Result hotList() {
        return Result.data(teaService.hotList());
    }

    @PostMapping("/admin/add")
    public Result add(@RequestBody TeaDto teaDto) {
        try {
            teaService.add(teaDto);
            return Result.ok();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/admin/addImg")
    public Result updateImg(@RequestBody TeaImgDto teaImgDto) {
        try {
            teaService.updateImg(teaImgDto);
            return Result.ok();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/admin/deleteImg")
    public Result deleteImg(@RequestBody TeaImgDto teaImgDto) {
        try {
            teaService.deleteImg(teaImgDto);
            return Result.ok();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/admin/update")
    public Result update(@RequestBody TeaDto teaDto) {
        try {
            teaService.update(teaDto);
            return Result.ok();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/admin/delete")
    public Result delete(@RequestParam Integer teaId) {
        try {
            teaService.delete(teaId);
            return Result.ok();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
}
