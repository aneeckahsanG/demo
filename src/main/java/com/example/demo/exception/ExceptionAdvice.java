//package com.example.demo.exception;
//
//import com.example.demo.model.response.ErrorResponse;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@ControllerAdvice
//public class ExceptionAdvice {
////    @Value("${drees.stacktrace}")
//    boolean stackTrace = false;
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ErrorResponse<List<StackTraceElement>> processAllError(Exception ex) {
//        List<StackTraceElement> ele = null;
//        if (stackTrace == true) {
//            ele = Arrays.asList(ex.getStackTrace());
//        }
//        ErrorResponse<List<StackTraceElement>> response = new ErrorResponse<>(ele, ex.getMessage());
//        return response;
//    }
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorResponse<List<String>> handleConstraintViolationException(ConstraintViolationException ex) {
//        List<String> details = new ArrayList<>();
//        for(ConstraintViolation error : ex.getConstraintViolations()) {
//            details.add(error.getMessage());
//        }
//        ErrorResponse error = new ErrorResponse(details, "Validation Failed");
//        return error;
//    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ErrorResponse<List<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//        List<String> details = new ArrayList<>();
//        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
//            details.add(error.getDefaultMessage());
//        }
//        ErrorResponse error = new ErrorResponse(details, "Validation Failed");
//        return error;
//    }
//}
