package com.pixeltechnology.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int statusCode;
    private String message;

    public ApiResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ApiResponse [statusCode=" + statusCode + ", message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiResponse(String message) {
        super();
        this.message = message;
    }

	public ApiResponse() {
		super();
	}
}
