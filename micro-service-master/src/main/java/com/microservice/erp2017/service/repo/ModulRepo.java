package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.M_Modul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("ModulRepo")
public interface ModulRepo extends JpaRepository<M_Modul, Integer>{
    
}
