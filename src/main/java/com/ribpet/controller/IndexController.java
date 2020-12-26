package com.ribpet.controller;

import com.ribpet.component.TokenService;
import com.ribpet.dto.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class IndexController {

    @PostMapping(path = "/login", produces = APPLICATION_JSON_VALUE)
    public AjaxResult login(String username, String password) {
        // 模拟数据库操作
        if ("admin".equals(username) && "admin123".equals(password)) {
            return AjaxResult.success("操作成功", tokenService.createToken(username));
        }

        return AjaxResult.error("账号或密码错误");
    }

    @GetMapping(path = "/index", produces = APPLICATION_JSON_VALUE)
    public AjaxResult execute(@RequestHeader("Authorization") String token) {
        return AjaxResult.success(tokenService.getSubject(token));
    }

    @Autowired
    private TokenService tokenService;
}