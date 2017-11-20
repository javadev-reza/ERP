package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_Religion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("ReligionRepo")
public interface ReligionRepo extends JpaRepository<M_Religion, Integer>{
    
}
