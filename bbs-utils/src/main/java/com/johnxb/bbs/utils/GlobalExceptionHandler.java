package com.johnxb.bbs.utils;

import com.johnxb.bbs.utils.exception.BusinessException;
import com.johnxb.bbs.utils.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
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
//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseBody
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    JSONResult handleAccessDeniedException(AccessDeniedException e) {
//        JSONResult jsonResult = new JSONResult();
//        jsonResult.setMessage(e.getMessage());
//        return jsonResult;
//    }
    /**
     * 处理数据验证异常，验证数据的异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handleBindException(MethodArgumentNotValidException e) {
        List<Map<String, Object>> errorList = new ArrayList<>();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            Map<String, Object> error = new HashMap<>();
            error.put("field", fieldError.getField());
            error.put("code", fieldError.getCode());
            error.put("message", fieldError.getDefaultMessage());
            errorList.add(error);
        }
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("VALIDATION_ERROR");
        jsonResult.setMessage(errorList);
        return jsonResult;
    }


    /**
     * @param e 未找到异常
     * @return
     * 未找到异常统一处理
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    JSONResult handleNotFoundException(NotFoundException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode(e.getErrorCode());
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }
}
