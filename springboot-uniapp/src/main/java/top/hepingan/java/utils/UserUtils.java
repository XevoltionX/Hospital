package top.hepingan.java.utils;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;

/**
 * 用户工具类
 * @author  @github dulaiduwang003
 * @version 1.0
 */
public class UserUtils {


    public static Long getLoginIdByToken(final String token) {
        final Object loginIdObject = StpUtil.getLoginIdByToken(token);
        return Long.parseLong(String.valueOf(loginIdObject));
    }

    //获取登录人id
    public static Integer getCurrentLoginId() {
        return Integer.parseInt(String.valueOf(StpUtil.getLoginId()));
    }

}
