package com.universe.spring.exception;

import com.universe.spring.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * 全局异常处理
 * @author lx
 */
@Slf4j
@ControllerAdvice
public class HandlerException {

    /**
     * 业务异常处理
     * @param e 自定义异常
     * @return ApiResponse
     */
    @ResponseBody
    @ExceptionHandler(value = {BizException.class})
    public ApiResponse handleBusinessException(BizException e){

        log.warn("业务处理响应处理失败 errorCode:[{}] errorMessage:[{}] data:[{}]", e.getErrCode(), e.getErrMessage(), e.getData());
        return ApiResponse.error(e.errCode, e.errMessage, e.data);
    }

    /**
     * 未知异常处理
     * @param request
     * @param t
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public ApiResponse handleUnexpectedException(HttpRequest request, Throwable t){

        log.error("系统异常：URL：{},异常信息：{}",request.getURI(),t.getMessage());
        return ApiResponse.error("系统异常");
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class, TypeMismatchException.class
    , BindException.class, MaxUploadSizeExceededException.class})
    @ResponseBody
    public ApiResponse handleParamException(Throwable t){
        // 缺少必填项异常处理
        if (t instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException exception = (MissingServletRequestParameterException)t;
            return ApiResponse.error(12,exception.getParameterName() + "is required",null);
        }
        return ApiResponse.error();
    }
}
