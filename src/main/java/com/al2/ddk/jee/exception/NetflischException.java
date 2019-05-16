package com.al2.ddk.jee.exception;

public class NetflischException extends Exception {
	
	/***/
	private static final long serialVersionUID = 1L;
	/***/
	private int errorCode;
	/***/
	private String errorMsg;
	
	public NetflischException() {}
	
	/** 
	 * @param cause
	 */
	public NetflischException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public NetflischException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * @param errorCode
	 * @param errorMsg
	 */
	public NetflischException(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	/**
	 * @param errorCode
	 */
	public NetflischException(int errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * @param errorMsg
	 */
	public NetflischException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
