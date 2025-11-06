package errorhandling.domain;

import org.springframework.http.HttpStatus;

public enum ErrorType {
    INVALID_REQUEST(
            "ERR_INVALID_REQUEST",
            "Некорректный запрос",
            HttpStatus.BAD_REQUEST
    ),
    UNPROCESSABLE_ENTITY(
            "ERR_UNPROCESSABLE_ENTITY",
            "Не нужен тебе такой объект братан",
            HttpStatus.UNPROCESSABLE_ENTITY
    ),
    NOT_FOUND(
            "ERR_NOT_FOUND",
            "Ресурс не найден",
            HttpStatus.NOT_FOUND
    ),
    METHOD_NOT_ALLOWED(
            "ERR_METHOD_NOT_ALLOWED",
            "Метод не поддерживается",
            HttpStatus.METHOD_NOT_ALLOWED
    ),
    SERVER_ERROR(
            "ERR_SERVER_ERROR",
            "Внутреняя ошибка сервера",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),
    DRAGON_HEAD_CREATE_ERROR(
            "ERR_DRAGON_HEAD_CREATE_ERROR",
            "Не удалось создать dragon head",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),
    COORDINATES_CREATE_ERROR(
            "ERR_COORDINATES_CREATE_ERROR",
            "Не удалось создать coordinates",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),
    DRAGON_CREATE_ERROR(
            "ERR_DRAGON_CREATE_ERROR",
            "Не удалось создать dragon",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),
    DRAGON_NOT_FOUND(
            "ERR_DRAGON_NOT_FOUND_ERROR",
            "Dragon не найден",
            HttpStatus.NOT_FOUND
    ),
    COORDINATES_NOT_FOUND(
            "ERR_COORDINATES_NOT_FOUND_ERROR",
            "Coordinates не найдены",
            HttpStatus.NOT_FOUND
    ),
    DRAGON_HEAD_NOT_FOUND(
            "ERR_DRAGON_HEAD_NOT_FOUND_ERROR",
            "Dragon Head не найден",
            HttpStatus.NOT_FOUND
    );

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorType(String code, String message, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }
}