package com.ribpet.exceptions;

import com.ribpet.dto.AjaxResult;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SignatureException.class)
    @ResponseBody
    public AjaxResult signatureException() {
        return AjaxResult.error("Token为空");
    }

    @ResponseBody
    @ExceptionHandler(ExpiredJwtException.class)
    public AjaxResult expiredJwtException() {
        return AjaxResult.error("Token过期");
    }

    @ResponseBody
    @ExceptionHandler(MalformedJwtException.class)
    public AjaxResult malformedJwtException() {
        return AjaxResult.error("Token数据错误");
    }
}