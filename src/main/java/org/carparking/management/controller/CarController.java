package org.carparking.management.controller;

import java.util.List;

import org.carparking.management.jpa.dao.model.Car;
import org.carparking.management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author nareshd
 *
 */
@RestController
@RequestMapping("/carParking/")
@ActiveProfiles(value = "development")
public class CarController {

	@Autowired
	CarService carService;

	@RequestMapping(value = "/carCheckIn", method = RequestMethod.POST)
	@ApiOperation(value = "Car Parking Check-In Service", notes = "Returns a car parking check-in service details. SLA:500", response = Car.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Car Parked Successfully", response = Car.class),
			@ApiResponse(code = 400, message = "Invalid Input Provided"),
			@ApiResponse(code = 404, message = "Car Parking Check-In Deatils Does Not Exist") })
	public Car doCarParking(@RequestBody Car cars) {

		Car car = null;
		try {
			validateCarParking(cars);
			car = carService.doCarParkingCheckIn(cars);
		} catch (Exception e) {
			System.out.println("My Exception in Controller : " + e);
		}
		return car;
	}

	@RequestMapping(value = "/carCheckOut", method = RequestMethod.POST)
	@ApiOperation(value = "Car Parking Check-Out Service", notes = "Returns a car parking check-out service details. SLA:500", response = Car.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Car Check-Out Successfully", response = Car.class),
			@ApiResponse(code = 400, message = "Invalid Input Provided"),
			@ApiResponse(code = 404, message = "Car Parking Check-Out Deatils Does Not Exist") })
	public Car doCarCheckout(@RequestBody Car cars) {

		Car updatedCar = null;
		try {
			validateCarParking(cars);
			updatedCar = carService.doCarParkingCheckOut(cars);
		} catch (Exception e) {
			System.out.println("My Exception in Controller : " + e);
		}
		return updatedCar;
	}

	@RequestMapping(value = "/getCarDetailsByCarNo", method = RequestMethod.POST)
	@ApiOperation(value = "Get Car Parking Details Service", notes = "Returns a Car parking service details. SLA:500", response = Car.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrived Car Parking Details ", response = Car.class),
			@ApiResponse(code = 400, message = "Invalid Input Provided"),
			@ApiResponse(code = 404, message = "Car Parking Deatils Does Not Exist") })
	public Car getParkedCarDetailsByCarNo(@RequestBody Car cars) {

		Car getCarDetails = null;
		try {
			validateCarParking(cars);
			getCarDetails = carService.getCarParkingDetailsByCarNo(cars);
		} catch (Exception e) {
			System.out.println("My Exception in Controller : " + e);
		}
		return getCarDetails;
	}
	
	@RequestMapping(value = "/updateCarDetails", method = RequestMethod.POST)
	@ApiOperation(value = "Get Car Parking Details Service", notes = "Returns a Car parking service details. SLA:500", response = Car.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrived Car Parking Details ", response = Car.class),
			@ApiResponse(code = 400, message = "Invalid Input Provided"),
			@ApiResponse(code = 404, message = "Car Parking Deatils Does Not Exist") })
	public Car updatedParkedCarDetails(@RequestBody Car cars) {

		Car getCarDetails = null;
		try {
			validateCarParking(cars);
			getCarDetails = carService.getCarParkingDetailsByCarNo(cars);
		} catch (Exception e) {
			System.out.println("My Exception in Controller : " + e);
		}
		return getCarDetails;
	}
	
	@RequestMapping(value = "/getCarDetailsByCriteria", method = RequestMethod.POST)
	@ApiOperation(value = "Get Car Parking Details Service", notes = "Returns a Car parking service details. SLA:500", response = Car.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Retrived Car Parking Details ", response = Car.class),
			@ApiResponse(code = 400, message = "Invalid Input Provided"),
			@ApiResponse(code = 404, message = "Car Parking Deatils Does Not Exist") })
	public List<Car> getParkedCarDetailsByCriteria(@RequestBody Car cars) {

		List<Car> getCarDetails = null;
		try {
			validateCarParking(cars);
			getCarDetails = carService.getCarDetailsByCriteria(cars);
		} catch (Exception e) {
			System.out.println("My Exception in Controller : " + e);
		}
		return getCarDetails;
	}


	private void validateCarParking(Car cars) {
		// Trim the Field Values.
		cars.setCarNo(cars.getCarNo() == null ? "" : cars.getCarNo().trim());
		cars.setCarType(cars.getCarType() == null ? "" : cars.getCarType().trim());
		cars.setOwerMblNo(cars.getOwerMblNo() == null ? "" : cars.getOwerMblNo().trim());
		cars.setOwnerName(cars.getOwnerName() == null ? "" : cars.getOwnerName().trim());
	}
}
