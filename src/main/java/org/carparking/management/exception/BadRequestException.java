package org.carparking.management.exception;

/**
 * @author nareshd
 *
 */
public class BadRequestException extends Exception {
	private static final long serialVersionUID = -3992797190692194686L;
	private final String errCode;

	public BadRequestException(String errCode, String errDesc) {
		super(errDesc);
		this.errCode = errCode;

	}

	/**
	 * Get the Error Code
	 * 
	 * @return as a String
	 */
	public String getErrCode() {
		return this.errCode;

	}
}