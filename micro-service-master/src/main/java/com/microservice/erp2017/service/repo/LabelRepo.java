package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("LabelRepo")
public interface LabelRepo extends JpaRepository<M_Label, Integer>{
    
}
