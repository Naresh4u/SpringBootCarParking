package org.carparking.management.jpa.repository;

import java.util.List;

import org.carparking.management.jpa.dao.model.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nareshd
 *
 */
public interface CarRepository extends JpaRepository<Car, String> {
	
	Car findAll(Specification<Car> carSpec);
	
	Car findByCarNo(String carNo);
	
	List<Car> findAll(Specification<Car> car, Sort dir);
	
//	void deleteAll(Specification<Car> car);
}
