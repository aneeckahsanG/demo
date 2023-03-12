package com.example.demo.exception;

import com.example.demo.model.response.ErrorDTO;
import com.example.demo.model.response.ErrorResponse;
import com.example.demo.model.response.SuccessDTO;
import com.example.demo.model.response.SuccessResponse;
import com.example.demo.utils.IgnoreResponseBinding;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class CustomResponseAdvise implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (o instanceof ErrorDTO){
            return new ResponseEntity<>(o, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else if (o instanceof SuccessDTO){
            return new ResponseEntity<>(o, HttpStatus.OK);
        }
        else {
            if(o == null){
                o = "Operation Successful";
            }
            SuccessDTO<Object> responseBody = new SuccessDTO<>(o);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
    }
}
// if (methodParameter.getContainingClass().isAnnotationPresent(RestController.class)) {
//        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseBinding.class) == false) {
//        if ((!(o instanceof ErrorResponse)) && (!(o instanceof SuccessResponse))) {
//        if(o == null){
//        o = "Operation Successful";
//        }
//        SuccessDTO<Object> responseBody = new SuccessDTO<>(o);
//        return new ResponseEntity<>(responseBody, HttpStatus.OK);
//
//        }
//        }
//        }