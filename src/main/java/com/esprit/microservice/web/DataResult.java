package com.esprit.microservice.web;

public class DataResult<T> {

	
	private T data;
	private String message;
	private boolean status;
	
	
	
	
	public DataResult(String message, boolean status, T data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public String getMessage() {
		return message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
