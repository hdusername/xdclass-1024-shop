package net.xdclass.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.xdclass.request.UserLoginRequest;
import net.xdclass.service.UserService;
import net.xdclass.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hd
 * @since 2023-09-02
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/api/user/v1")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("login")
    public JsonData login(@ApiParam("用户登录对象") @RequestBody UserLoginRequest userLoginRequest){
        JsonData jsonData = userService.login(userLoginRequest);
        return jsonData;
    }

}

