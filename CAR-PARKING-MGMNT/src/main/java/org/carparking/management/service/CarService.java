package org.carparking.management.service;

import java.util.Date;
import org.carparking.management.jpa.dao.model.Car;
import org.carparking.management.jpa.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nareshd
 *
 */
@Service
public class CarService {

	@Autowired
	CarRepository carRepository;

	public Car doCarParkingCheckIn(Car cars) throws Exception {
		Car car = null;
		try {
			Car carDao = cars;
			carDao.setCheckIn(new Date());
			car = carRepository.save(carDao);
		} catch (Exception e) {
			System.out.println("My Error :" + e);
		}
		return car;
	}

	public Car doCarParkingCheckOut(Car cars) throws Exception {
		Car onCar = null;
		Car carUpdated = null;
		try {
			carUpdated = carRepository.findByCarNo(cars.getCarNo());
			Date date = carUpdated.getCheckOut();
			if (date == null || date.equals("")) {
				carUpdated.setCheckOut(new Date());
			}
			Long totalParkTym = getDifferenceDays(carUpdated.getCheckIn(), carUpdated.getCheckOut());
			carUpdated.setTotalParkedTime(totalParkTym);
			Long pcharge = calParkingTime(totalParkTym, 0L, 0L);
			if (pcharge!=null) {
				carUpdated.setParkingCharge(pcharge);
			}
			onCar = carRepository.save(carUpdated);
		} catch (Exception e) {
			System.out.println("My Error :" + e);
		}
		return onCar;
	}
	
	public Car getCarParkingDetails(Car cars) throws Exception {
		Car getCarDetails = null;
		try {
			getCarDetails = carRepository.findByCarNo(cars.getCarNo());
			
			if(getCarDetails==null)
			{
				throw new Exception(" Get Car Details Not Found ");
			}
		
		} catch (Exception e) {
			System.out.println("My Error :" + e);
		}
		return getCarDetails;
	}

	private Long getDifferenceDays(Date checkIn, Date checkOut) {
		Long daysdiff;
		long diff = checkOut.getTime() - checkIn.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
		daysdiff = diffDays;
		return daysdiff;
	}

	private Long calParkingTime(Long days, Long hours, Long minutes) {
		return (days * 20) + (hours * 4) + (minutes * 2);
	}

	private Car validateUpdateFields(Car car, Car existingcar) {

		String carNo = car.getCarNo();

		String carType = car.getCarType();

		Date checkIn = car.getCheckIn();

		Date checkOut = car.getCheckOut();

		String owerMblNo = car.getOwerMblNo();

		String ownerName = car.getOwnerName();

		Long totalParkedTime = car.getTotalParkedTime();

		Long parkingCharge = car.getParkingCharge();

		car.setCarNo(validateNullOrEmptyField(carNo) ? existingcar.getCarNo()
				: (validateNullOrEmptyField(carNo) ? null : carNo));

		car.setCarType(validateNullOrEmptyField(carType) ? existingcar.getCarType()
				: (validateNullOrEmptyField(carType) ? null : carType));

		car.setCheckIn(
				validateDateField(checkIn) ? existingcar.getCheckIn() : (validateDateField(checkIn) ? null : checkIn));

		car.setCheckOut(validateDateField(checkOut) ? existingcar.getCheckOut()
				: (validateDateField(checkOut) ? null : checkOut));

		car.setOwerMblNo(validateNullOrEmptyField(owerMblNo) ? existingcar.getOwerMblNo()
				: (validateNullOrEmptyField(owerMblNo) ? null : owerMblNo));

		car.setOwnerName(validateNullOrEmptyField(ownerName) ? existingcar.getOwnerName()
				: (validateNullOrEmptyField(ownerName) ? null : ownerName));

		car.setTotalParkedTime(validateLongField(totalParkedTime) ? existingcar.getTotalParkedTime()
				: (validateLongField(totalParkedTime) ? null : totalParkedTime));

		car.setParkingCharge(validateLongField(parkingCharge) ? existingcar.getParkingCharge()
				: (validateLongField(parkingCharge) ? null : parkingCharge));

		return existingcar;
	}

	/**
	 * This function will check if field value is Empty or Null
	 * 
	 * @param fieldValue
	 * @return
	 */
	private Boolean validateNullOrEmptyField(String fieldValue) {

		return fieldValue == null || fieldValue.trim().isEmpty();

	}

	/**
	 * Validate the Date Field.
	 * 
	 * @param fieldValue
	 * @return
	 */
	private Boolean validateDateField(Date fieldValue) {

		return fieldValue == null;

	}

	/**
	 * @param fieldValue
	 * @return
	 */
	private Boolean validateLongField(Long fieldValue) {

		return fieldValue == null;

	}

}
