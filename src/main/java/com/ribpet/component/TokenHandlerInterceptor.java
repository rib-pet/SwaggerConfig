package com.ribpet.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;

@Component
public class TokenHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();
        if (uri.contains("/login")) {
            return true;
        }

        String token = request.getHeader(header);
        if (StringUtils.isBlank(token)) {
            throw new SignatureException(StringUtils.EMPTY);
        }

        tokenService.getBody(token);

        return true;
    }

    @Autowired
    private TokenService tokenService;

    // 令牌自定义标识
    @Value("${token.header}")
    private String       header;
}
