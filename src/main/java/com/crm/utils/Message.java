package com.crm.utils;

/**
 * 用于记录前台后台之间交互,所得到的结果信息.
 */
public class Message {
	
	private String success;
	private String error;
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
