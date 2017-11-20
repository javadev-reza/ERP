package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("ProvinceRepo")
public interface ProvinceRepo extends JpaRepository<M_Province, Integer>{
    
}
