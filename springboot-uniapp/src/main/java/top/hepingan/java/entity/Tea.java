package top.hepingan.java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("tea")
public class Tea {

    @TableId(type = IdType.AUTO)
    private Integer teaId;

    private String teaName;

    private Double price;

    private Double discountPrice;

    private String introduce;

    private String category;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private Boolean isHot;
}
