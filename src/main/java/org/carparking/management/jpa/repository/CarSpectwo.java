package org.carparking.management.jpa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.carparking.management.constants.CarConstants;
import org.carparking.management.jpa.dao.model.Car;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author nareshd
 *
 */
public class CarSpectwo implements Specification<Car> {

    final Car car;

    public CarSpectwo(Car car) {
	this.car = car;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
     */
    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

	List<Predicate> criteria = new ArrayList<Predicate>();
	
	String carNo = car.getCarNo();
	String carType = car.getCarType();
	String owerMblNo = car.getOwerMblNo();
	String ownerName = car.getOwnerName();
	
	if (car != null) {
	    
	    	if (carNo != null && !carNo.isEmpty()) {
		    if (carNo.equalsIgnoreCase(CarConstants.NULL_VALUE)) {
			criteria.add(cb.isNull(root.get("carNo")));
		    } else {
			criteria.add(cb.equal(root.get("carNo"), carNo.trim()));
		    }
		}

		if (carType != null && !carType.isEmpty()) {
		    if (carType.equalsIgnoreCase(CarConstants.NULL_VALUE)) {
			criteria.add(cb.isNull(root.get("carType")));
		    } else {
			criteria.add(cb.equal(root.get("carType"), carType.trim()));
		    }
		}
		
		if (owerMblNo != null && !owerMblNo.isEmpty()) {
		    if (owerMblNo.equalsIgnoreCase(CarConstants.NULL_VALUE)) {
			criteria.add(cb.isNull(root.get("owerMblNo")));
		    } else {
			criteria.add(cb.equal(root.get("owerMblNo"), owerMblNo.trim()));
		    }
		}
		
		if (ownerName != null && !ownerName.isEmpty()) {
		    if (ownerName.equalsIgnoreCase(CarConstants.NULL_VALUE)) {
			criteria.add(cb.isNull(root.get("ownerName")));
		    } else {
			criteria.add(cb.equal(root.get("ownerName"), ownerName.trim()));
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
