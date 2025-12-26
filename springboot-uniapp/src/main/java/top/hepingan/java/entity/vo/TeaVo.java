package top.hepingan.java.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class TeaVo {

    private Integer teaId;

    private String teaName;

    private Double price;

    private Double discountPrice;

    private String introduce;

    private String category;

    private List<String> imageList;

    private LocalDateTime createdTime;
}
