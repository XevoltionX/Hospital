package top.hepingan.java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.hepingan.java.entity.User;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
