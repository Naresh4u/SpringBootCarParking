package org.carparking.management.jpa.dao.model;

import java.util.Date;

/**
 * @author nareshd
 *
 */
public class CarResponse {
	private int carNo;
	private String carType;
	private Date checkIn;
	private Date checkOut;
	private String owerMblNo;
	private String ownerName;
	private Date totalParkedTime;

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public String getOwerMblNo() {
		return owerMblNo;
	}

	public void setOwerMblNo(String owerMblNo) {
		this.owerMblNo = owerMblNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Date getTotalParkedTime() {
		return totalParkedTime;
	}

	public void setTotalParkedTime(Date totalParkedTime) {
		this.totalParkedTime = totalParkedTime;
	}

}
