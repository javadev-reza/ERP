package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.T_DriverAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("DriverAddressRepo")
public interface DriverAddressRepo extends JpaRepository<T_DriverAddress, String>{
    
}
