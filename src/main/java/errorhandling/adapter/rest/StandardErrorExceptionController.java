package errorhandling.adapter.rest;


import errorhandling.domain.ErrorType;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import utils.LoggerUtil;
import utils.ResponseUtil;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE + Ordered.HIGHEST_PRECEDENCE)
public class StandardErrorExceptionController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.INVALID_REQUEST);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.INVALID_REQUEST);
        LoggerUtil.logger.error("parameter " + e.getParameterName(), e);
        return response;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Object handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.INVALID_REQUEST);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.UNPROCESSABLE_ENTITY);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Object handleConstraintViolationException(ConstraintViolationException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.INVALID_REQUEST);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public Object handleNoResourceFoundException(NoResourceFoundException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.NOT_FOUND);
        LoggerUtil.logger.error("path=" + e.getResourcePath(), e);
        return response;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.METHOD_NOT_ALLOWED);
        LoggerUtil.logger.error("method=" + e.getMethod(), e);
        return response;
    }
}