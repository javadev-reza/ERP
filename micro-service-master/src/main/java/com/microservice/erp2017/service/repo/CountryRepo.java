package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("CountryRepo")
public interface CountryRepo extends JpaRepository<M_Country, Integer>{
    
}
