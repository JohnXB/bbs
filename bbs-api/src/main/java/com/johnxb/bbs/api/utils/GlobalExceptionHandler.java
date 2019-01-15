package com.johnxb.bbs.api.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handleBusinessException(BusinessException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode(e.getErrorCode());
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }
}
