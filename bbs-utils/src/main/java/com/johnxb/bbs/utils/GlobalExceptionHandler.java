package com.johnxb.bbs.utils;

import com.johnxb.bbs.utils.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerAdvice
@CrossOrigin
public class GlobalExceptionHandler{
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handleBusinessException(BusinessException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode(e.getErrorCode());
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }
    /**
     * 权限鉴定异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    JSONResult handleAccessDeniedException(AccessDeniedException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }
}
