package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("CityRepo")
public interface CityRepo extends JpaRepository<M_City, Integer>{
    
}
