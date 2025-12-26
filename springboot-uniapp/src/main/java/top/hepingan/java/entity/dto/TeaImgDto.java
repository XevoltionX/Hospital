package top.hepingan.java.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

@Data
@Accessors(chain = true)
public class TeaImgDto {

    private Integer teaId;

    private MultipartFile image;

    private String imgUrl;
}
