package org.carparking.management.jpa.dao.model;

import java.math.BigDecimal;
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
	private static final long serialVersionUID = 1L;

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

	@Column(name = "parked_time_indays")
	private Long parkedTimeIndays;

	@Column(name = "parked_time_inhours")
	private Long parkedTimeInhours;

	@Column(name = "parked_time_inminitues")
	private Long parkedTimeInminitues;

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

	public Long getParkedTimeIndays() {
		return this.parkedTimeIndays;
	}

	public void setParkedTimeIndays(Long parkedTimeIndays) {
		this.parkedTimeIndays = parkedTimeIndays;
	}

	public Long getParkedTimeInhours() {
		return this.parkedTimeInhours;
	}

	public void setParkedTimeInhours(Long parkedTimeInhours) {
		this.parkedTimeInhours = parkedTimeInhours;
	}

	public Long getParkedTimeInminitues() {
		return this.parkedTimeInminitues;
	}

	public void setParkedTimeInminitues(Long parkedTimeInminitues) {
		this.parkedTimeInminitues = parkedTimeInminitues;
	}

	public Long getParkingCharge() {
		return this.parkingCharge;
	}

	public void setParkingCharge(Long parkingCharge) {
		this.parkingCharge = parkingCharge;
	}

}
