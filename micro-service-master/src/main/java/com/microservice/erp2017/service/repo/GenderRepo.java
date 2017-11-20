package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("GenderRepo")
public interface GenderRepo extends JpaRepository<M_Gender, Integer>{
    
}
