package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("LanguageRepo")
public interface LanguageRepo extends JpaRepository<M_Language, Integer>{
    
}
