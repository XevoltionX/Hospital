package top.hepingan.java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("tea_images")
public class TeaImages {

    @TableId(type = IdType.AUTO)
    private Integer teaImagesId;

    private Integer teaId;

    private String imgUrl;
}
