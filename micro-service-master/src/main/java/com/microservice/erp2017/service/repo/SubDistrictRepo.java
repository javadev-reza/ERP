package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_SubDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("SubDistrictRepo")
public interface SubDistrictRepo extends JpaRepository<M_SubDistrict, Integer>{
    
}
