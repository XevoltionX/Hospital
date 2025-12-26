package top.hepingan.java.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.hepingan.java.common.Result;
import top.hepingan.java.entity.User;
import top.hepingan.java.mapper.UserMapper;
import top.hepingan.java.utils.AliUploadUtils;
import top.hepingan.java.utils.UserUtils;
import top.hepingan.java.utils.WechatUtil;

import java.time.LocalDateTime;

@RequestMapping("/user")
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final WechatUtil wechatUtil;

    private final UserMapper userMapper;
    private final AliUploadUtils aliUploadUtils;

    /**
     * 账密登录
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User u = userMapper.selectOne(new QueryWrapper<User>().lambda()
                .eq(User::getUsername, user.getUsername())
                .eq(User::getPassword, user.getPassword()));
        if (u != null){
            StpUtil.login(u.getUserId());
            return Result.data(StpUtil.getTokenInfo());
        }else {
            return Result.error("登录失败");
        }
    }

    /**
     * 微信小程序登录
     * @return 登录结果
     */
    @PostMapping("/wx-login")
    public Result wxLogin(@RequestBody String code) {
        String openId = wechatUtil.getOpenId(code);
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getOpenId, openId));
        if (user == null) {
            user = new User();
            user.setOpenId(openId);
            user.setUsername("wx_"+openId.substring(0, 12));
            user.setRole("USER");
            user.setCreatedTime(LocalDateTime.now());
            userMapper.insert(user);
            StpUtil.login(user.getUserId());
            return Result.data(StpUtil.getTokenInfo());
        }else {
            StpUtil.login(user.getUserId());
            return Result.data(StpUtil.getTokenInfo());
        }
    }

    @GetMapping("/info")
    public Result info() {
        User user = userMapper.selectById(UserUtils.getCurrentLoginId());
        return Result.data(user);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        try {
            user.setUserId(UserUtils.getCurrentLoginId());
            userMapper.updateById(user);
            return Result.ok();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 修改头像
     * @param file
     * @return

    @PostMapping("/updateAvatar")
    public Result updateAvatar(@RequestBody MultipartFile file) {
        try {
            aliUploadUtils.deleteFile(userMapper.selectById(UserUtils.getCurrentLoginId()).getAvatar());
            String avatar = aliUploadUtils.uploadFile(file, "tea", null, true);
            User user = new User();
            user.setUserId(UserUtils.getCurrentLoginId());
            user.setAvatar(avatar);
            userMapper.updateById(user);
            return Result.ok();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

     */
}
