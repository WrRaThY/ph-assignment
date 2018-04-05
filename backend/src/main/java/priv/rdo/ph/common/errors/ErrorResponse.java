package priv.rdo.ph.common.errors;

import org.springframework.http.HttpStatus;

import static priv.rdo.ph.common.TimeProvider.nowAsString;

class ErrorResponse {
    private String timestamp = nowAsString();
    private int status;
    private String error;
    private String message;
    private String path;

    private ErrorResponse(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    static ErrorResponse of(HttpStatus httpStatus, String path, String message) {
        return new ErrorResponse(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                message,
                path
        );
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
