package top.hepingan.java.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("user")
@Accessors(chain = true)
public class User {

    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String password;

    private String openId;

    private String role;

    private LocalDateTime createdTime;
}
