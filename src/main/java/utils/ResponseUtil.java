package utils;

import errorhandling.adapter.rest.dto.ErrorDTO;
import errorhandling.domain.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static <DTO> ResponseEntity<DTO> buildSuccessResponse(DTO data) {
        HttpStatus status = (data == null) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return ResponseEntity.status(status).body(data);
    }

    public static <DTO> ResponseEntity<DTO> buildCreateResponse(DTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    public static ResponseEntity<ErrorDTO> buildErrorResponse(ErrorType type) {
        ErrorDTO errorDTO = new ErrorDTO(type.getCode(), type.getMessage());
        return ResponseEntity.status(type.getStatus()).body(errorDTO);
    }
}