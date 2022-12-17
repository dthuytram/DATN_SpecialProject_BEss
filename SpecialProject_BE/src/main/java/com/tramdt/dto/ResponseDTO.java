package com.tramdt.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class ResponseDTO {
    private HttpStatus status;
    private String message;

    public ResponseDTO() {
    }

    private Object body;

    public ResponseDTO(HttpStatus status, String message, Object body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public ResponseDTO(HttpStatus notFound, String message) {
    }
}
