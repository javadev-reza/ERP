package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("DistrictRepo")
public interface DistrictRepo extends JpaRepository<M_District, Integer>{
    
}
