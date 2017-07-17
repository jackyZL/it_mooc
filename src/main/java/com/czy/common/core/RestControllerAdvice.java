package com.czy.common.core;

import com.czy.common.constant.MessageCode;
import com.czy.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestControllerAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerAdvice.class);

    /**
     * Controller 所有异常捕获
     *
     * @param request
     * @param throwable
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<CommonResponse> error(HttpServletRequest request, Throwable throwable) {
        CommonResponse resp = new CommonResponse();

        ResponseEntity<CommonResponse> responseEntity = null;

        // 请求参数错误返回
        if (throwable instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) throwable;
            LOGGER.warn("Invalid arguments {}", e.getMessage());

            StringBuilder result = new StringBuilder();
            result.append(e.getBindingResult().getErrorCount()).append(" error(s): ");
            for (ObjectError error : e.getBindingResult().getAllErrors()) {
                if (error instanceof FieldError) {
                    FieldError fieldError = (FieldError) error;
                    result.append("[").append(fieldError.getField()).append("=").append(fieldError.getRejectedValue())
                            .append(",").append(error.getDefaultMessage()).append("]");
                } else {
                    result.append("[").append(error.getDefaultMessage()).append("]");
                }
            }

            resp.setCode(MessageCode.INVALID_PARAM.msgCode());
            resp.setMsg(result.toString());
            responseEntity = new ResponseEntity<CommonResponse>(resp, HttpStatus.OK);
        } else if (throwable instanceof MissingServletRequestParameterException) { // 参数缺省
            LOGGER.error("requried arguments {}", throwable.getMessage());
            resp.setCode(MessageCode.LACK_PARAM.msgCode());
            resp.setMsg(MessageCode.LACK_PARAM.msg());
            responseEntity = new ResponseEntity<CommonResponse>(resp, HttpStatus.OK);
        }
        // 业务错误返回
        else if (throwable instanceof BusinessException) {
            LOGGER.warn("BusinessException {}", throwable.getMessage());

            BusinessException be = (BusinessException) throwable;
            resp.setCode(be.getMessageCode().msgCode());
            resp.setMsg(be.getMessage());
            responseEntity = new ResponseEntity<CommonResponse>(resp, HttpStatus.OK);
        } else if (throwable instanceof HttpRequestMethodNotSupportedException) {

            // 请求方法错误
            LOGGER.error("Error", throwable);
            resp.setCode(MessageCode.METHOD_NOT_ALLOWED.msgCode());
            resp.setMsg(MessageCode.METHOD_NOT_ALLOWED.msg());
            responseEntity = new ResponseEntity<CommonResponse>(resp, HttpStatus.METHOD_NOT_ALLOWED);
        } else {
            // 系统出错返回
            LOGGER.error("Error", throwable);

            resp.setCode(MessageCode.SERVER_ERROR.msgCode());
            resp.setMsg(MessageCode.SERVER_ERROR.msg());
            responseEntity = new ResponseEntity<CommonResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return responseEntity;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 封装业务内容到data字段里面
     */
    @Override
    public CommonResponse beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                          Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                          ServerHttpResponse response) {

        CommonResponse resp = new CommonResponse();
        resp.setData(body);
        resp.setCode(MessageCode.SUCCESS.msgCode());

        return body instanceof CommonResponse ? (CommonResponse) body : resp;
    }

}
