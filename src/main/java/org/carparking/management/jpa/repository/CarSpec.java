package org.carparking.management.jpa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.carparking.management.jpa.dao.model.Car;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author nareshd
 *
 */
public class CarSpec implements Specification<Car> {

	final Car car;
	final Boolean mandatoryFields;
	final Boolean updateFields;

	/**
	 * @param car
	 */
	public CarSpec(Car car, Boolean mandatoryFields, Boolean updateFields) {
		this.car = car;
		this.mandatoryFields = mandatoryFields;
		this.updateFields = updateFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.
	 * persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery,
	 * javax.persistence.criteria.CriteriaBuilder)
	 */
	@Override
	public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

		List<Predicate> criteria = new ArrayList<>();
		if (car != null) {

			if (car.getCarNo() != null) {
				criteria.add(cb.equal(root.get("carNo"), car.getCarNo()));
			}

			if (car.getOwnerName() != null) {
				criteria.add(cb.equal(root.get("ownerName"), car.getOwnerName()));
			}

			if (updateFields && car.getCheckOut() != null) {
				criteria.add(cb.equal(root.get("checkOut"), car.getCheckOut()));
			}

			if (!mandatoryFields) {
				if (car.getCarType() != null) {
					criteria.add(cb.equal(root.get("carType"), car.getCarType()));
				}

				if (car.getOwerMblNo() != null) {
					criteria.add(cb.equal(root.get("owerMblNo"), car.getOwerMblNo()));
				}

				if (car.getParkingCharge() != null) {
					criteria.add(cb.equal(root.get("parkingCharge"), car.getParkingCharge()));
				}

				if (car.getParkedTimeInminitues() != null) {
					criteria.add(cb.equal(root.get("parkedTimeInminitues"), car.getParkedTimeInminitues()));
				}
				
				if (car.getParkedTimeInhours() != null) {
					criteria.add(cb.equal(root.get("parkedTimeInhours"), car.getParkedTimeInhours()));
				}
				
				if (car.getParkedTimeIndays() != null) {
					criteria.add(cb.equal(root.get("parkedTimeIndays"), car.getParkedTimeIndays()));
				}
			}
		}
		Predicate pred = null;

		if (criteria.size() == 1) {
			pred = criteria.get(0);
		} else if (criteria.size() > 1) {
			pred = cb.and(criteria.toArray(new Predicate[0]));
		}
		return pred;
	}

}
