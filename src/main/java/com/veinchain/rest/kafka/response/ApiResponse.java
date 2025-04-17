package com.veinchain.rest.kafka.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.Objects;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;

    public static ApiResponse build(boolean success, String message, Object data) {
        ApiResponse response = new ApiResponse();
        response.success = success;
        response.message = message;
        response.data = data != null ? data : "";
        return response;
    }

}
