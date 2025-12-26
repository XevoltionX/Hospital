package top.hepingan.java.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Accessors(chain = true)
public class TeaDto {

    private Integer teaId;

    private String teaName;

    private Double price;

    private Double discountPrice;

    private String introduce;

    private String category;

    private Boolean isHot;

    private List<MultipartFile> imageList;
}
