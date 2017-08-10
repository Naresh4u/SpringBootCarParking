package org.carparking.management.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.carparking.management.jpa.dao.model.Car;
import org.carparking.management.jpa.repository.CarRepository;
import org.carparking.management.jpa.repository.CarSpectwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
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
			Long parkedTimeIndays = calTymInDays(carUpdated.getCheckIn(), carUpdated.getCheckOut());

			Long parkedTimeInhours = calTymInHours(carUpdated.getCheckIn(), carUpdated.getCheckOut());

			Long parkedTimeInminitues = calTymInMinitues(carUpdated.getCheckIn(), carUpdated.getCheckOut());

			carUpdated.setParkedTimeInminitues(parkedTimeInminitues);
			carUpdated.setParkedTimeInhours(parkedTimeInhours);
			carUpdated.setParkedTimeIndays(parkedTimeIndays);

			Long pcharge = calParkingTime(parkedTimeIndays, parkedTimeInhours, parkedTimeIndays);
			if (pcharge != null) {
				carUpdated.setParkingCharge(pcharge);
			}
			onCar = carRepository.save(carUpdated);
		} catch (Exception e) {
			System.out.println("My Error :" + e);
		}
		return onCar;
	}

	private Long calParkingTime(Long days, Long hours, Long minutes) throws NullPointerException {
		Long zero=0L;
		if(days!=null && hours!=null && minutes!=null)
		{
			return (days * 20) + (hours * 2) + (minutes * 1);
		}
		else if(days==zero && hours!=null && minutes!=null)
		{
			return (hours * 2) + (minutes * 1);
		}
		else if(days!=null && hours==zero && minutes!=null)
		{
			return (days * 20) + (minutes * 1);
		}
		else if(days!=null && hours!=null && minutes==zero)
		{
			return (days * 20) + (hours * 2);
		}
		else
		{
			return zero;
		}
	}
	
	public Car getCarParkingDetailsByCarNo(Car cars) throws Exception {
		Car getCarDetails = null;
		try {
			getCarDetails = carRepository.findByCarNo(cars.getCarNo());

			if (getCarDetails == null) {
				throw new Exception(" Get Car Details Not Found ");
			}

		} catch (Exception e) {
			System.out.println("My Error :" + e);
		}
		return getCarDetails;
	}

	public List<Car> getCarDetailsByCriteria(Car car) throws Exception {
	   	List<Car> carList = null;

	   	try {
	   	 carList = carRepository.findAll(new CarSpectwo(car),
	   		    new org.springframework.data.domain.Sort(Direction.DESC, "carNo"));
	   	 
	   	} catch (Exception e) {
	   	    
	   	}
	   	return carList;
	   }


	private Long calTymInDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();// as given
		long days = TimeUnit.MILLISECONDS.toDays(diff);
		return days;
	}

	private Long calTymInHours(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();// as given
		long hours = TimeUnit.MILLISECONDS.toHours(diff);
		return hours;
	}

	private Long calTymInMinitues(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();// as given
		long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
		return minutes;
	}

	@SuppressWarnings("unused")
	private Car validateUpdateFields(Car car, Car existingcar) {

		String carNo = car.getCarNo();

		String carType = car.getCarType();

		Date checkIn = car.getCheckIn();

		Date checkOut = car.getCheckOut();

		String owerMblNo = car.getOwerMblNo();

		String ownerName = car.getOwnerName();

		Long parkedTimeIndays = car.getParkedTimeIndays();

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

		car.setParkedTimeIndays(validateLongField(parkedTimeIndays) ? existingcar.getParkedTimeIndays()
				: (validateLongField(parkedTimeIndays) ? null : parkedTimeIndays));

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
