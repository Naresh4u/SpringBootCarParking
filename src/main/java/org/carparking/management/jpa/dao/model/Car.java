package org.carparking.management.jpa.dao.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nareshd
 *
 */
@Entity
@Table(name = "carparking")
public class Car {

	@Id
	@Column(name = "car_no")
	private String carNo;

	@Column(name = "car_type")
	private String carType;

	@Column(name = "check_in")
	private Date checkIn;

	@Column(name = "check_out")
	private Date checkOut;

	@Column(name = "ower_mbl_no")
	private String owerMblNo;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "total_parked_time")
	private Long totalParkedTime;

	@Column(name = "parking_charge")
	private Long parkingCharge;

	public Car() {
	}

	public String getCarNo() {
		return this.carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Date getCheckIn() {
		return this.checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return this.checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public String getOwerMblNo() {
		return this.owerMblNo;
	}

	public void setOwerMblNo(String owerMblNo) {
		this.owerMblNo = owerMblNo;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Long getTotalParkedTime() {
		return this.totalParkedTime;
	}

	public void setTotalParkedTime(Long totalParkedTime) {
		this.totalParkedTime = totalParkedTime;
	}

	public Long getParkingCharge() {
		return parkingCharge;
	}

	public void setParkingCharge(Long parkingCharge) {
		this.parkingCharge = parkingCharge;
	}

}
