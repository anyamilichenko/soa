package errorhandling.adapter.rest.dto;

public class ErrorDTO {
    private final String errorCode;
    private final String errorMessage;

    public ErrorDTO(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}