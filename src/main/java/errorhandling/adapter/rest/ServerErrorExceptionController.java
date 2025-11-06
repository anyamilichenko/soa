package errorhandling.adapter.rest;


import errorhandling.domain.CoordinatesCreateException;
import errorhandling.domain.DragonCreateException;
import errorhandling.domain.DragonHeadCreateException;
import errorhandling.domain.ErrorType;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import utils.LoggerUtil;
import utils.ResponseUtil;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ServerErrorExceptionController {

    @ExceptionHandler(DragonHeadCreateException.class)
    public Object handleAddressCreateException(DragonHeadCreateException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.DRAGON_HEAD_CREATE_ERROR);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }

    @ExceptionHandler(CoordinatesCreateException.class)
    public Object handleCoordinatesCreateException(CoordinatesCreateException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.COORDINATES_CREATE_ERROR);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }

    @ExceptionHandler(DragonCreateException.class)
    public Object handleOrganizationCreateException(DragonCreateException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.DRAGON_CREATE_ERROR);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.SERVER_ERROR);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }
}