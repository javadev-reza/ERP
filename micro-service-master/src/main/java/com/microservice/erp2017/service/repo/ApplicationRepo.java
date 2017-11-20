package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("ApplicationRepo")
public interface ApplicationRepo extends JpaRepository<M_Application, Integer>{
    
}
