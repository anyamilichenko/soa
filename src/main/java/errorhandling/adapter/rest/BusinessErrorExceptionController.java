package errorhandling.adapter.rest;

import errorhandling.domain.ErrorType;
import errorhandling.domain.NoCoordinatesFoundException;
import errorhandling.domain.NoDragonFoundException;
import errorhandling.domain.NoDragonHeadFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import utils.LoggerUtil;
import utils.ResponseUtil;


@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BusinessErrorExceptionController {

    @ExceptionHandler(NoDragonFoundException.class)
    public Object handleNoDragonFoundException(NoDragonFoundException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.DRAGON_NOT_FOUND);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }

    @ExceptionHandler(NoCoordinatesFoundException.class)
    public Object handleNoCoordinatesFoundException(NoCoordinatesFoundException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.COORDINATES_NOT_FOUND);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }

    @ExceptionHandler(NoDragonHeadFoundException.class)
    public Object handleNoDragonHeadFoundException(NoDragonHeadFoundException e) {
        Object response = ResponseUtil.buildErrorResponse(ErrorType.DRAGON_HEAD_NOT_FOUND);
        LoggerUtil.logger.error(e.getMessage(), e);
        return response;
    }
}