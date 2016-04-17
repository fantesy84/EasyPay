package net.fantesy84.commons.bean;

import java.io.Serializable;

public abstract class BaseResponseDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Action action;
	private ResponseStatus status;
	private String code;
	private String message;
	private Object responseBody;
	
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public ResponseStatus getStatus() {
		return status;
	}
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}

	public static enum Action {
		SAVE,UPDATE,MERGE,DELETE,SELECT,SELECT_PK,SELECT_PAGINATION;
	}
	public static enum ResponseStatus {
		SUCCESS,ERROR;
	}
}
