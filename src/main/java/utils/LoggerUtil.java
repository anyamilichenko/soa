package utils;

import errorhandling.adapter.rest.dto.ErrorDTO;
import errorhandling.domain.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    public static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public static <T extends Exception> void error(T e, ErrorDTO dto, String suffix) {
        StringBuilder message = new StringBuilder();
        message.append("Exception=").append(e.getClass().getSimpleName());
        if (e.getMessage() != null) {
            message.append(", Message=\"").append(e.getMessage()).append("\"");
        }
        message.append(", DTO=").append(dto);
        if (suffix != null) {
            message.append(", Suffix=\"").append(suffix).append("\"");
        }

        String finalMessage = message.toString();
        if (dto != null && ErrorType.SERVER_ERROR.getCode().equals(dto.getErrorCode())) {
            logger.error(finalMessage, e);
        } else {
            logger.warn(finalMessage);
        }
    }

    public static <T extends Exception> void error(T e, ErrorDTO dto) {
        error(e, dto, null);
    }
}