package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.T_Company;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reza
 */
@Repository("CompanyRepo")
public interface CompanyRepo extends JpaRepository<T_Company, String>{
    
    @Query("select model "
            + "from T_Company model "
            + "where model.statusEnabled=true "
            + "and model.authCode=:authCode")
    T_Company getOneByAuthCode(
            @Param("authCode") String authCode);
    
    @Query("select new map ("
            + "a.code as code,"
            + "a.ownerName as ownerName,"
            + "a.companyName as companyName,"
            + "a.image as image) "
            + "from T_Company a "
            + "where a.code=:code ")
    Map getOneByCode(
            @Param("code") String code);
    
}
