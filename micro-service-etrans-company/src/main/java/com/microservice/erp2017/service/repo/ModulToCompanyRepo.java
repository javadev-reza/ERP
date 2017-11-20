package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.T_ModulToCompany;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("ModulToCompanyRepo")
public interface ModulToCompanyRepo extends JpaRepository<T_ModulToCompany, String>{
    
    @Query("select new map ("
            + "b.id as modulId,"
            + "b.modul as modulName) "
            + "from T_ModulToCompany a "
            + "left join a.modul b "
            + "where a.companyCode=:companyCode ")
    List<Map<String, Object>> getModulByCompanyCode(
            @Param("companyCode") String companyCode);
    
    @Query("select new map ("
            + "a.id as applicationId,"
            + "a.application as applicationName,"
            + "a.link as link,"
            + "a.price as price) "
            + "from M_Application a "
            + "where a.modulId=:modulId ")
    List<Map<String, Object>> getApplicationByModulId(
            @Param("modulId") Integer modulId); 
}
