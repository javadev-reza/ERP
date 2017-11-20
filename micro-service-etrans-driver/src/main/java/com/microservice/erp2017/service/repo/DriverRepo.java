package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.T_Driver;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reza
 */
@Repository("DriverRepo")
public interface DriverRepo extends JpaRepository<T_Driver, String>{
    
    @Query("select model from T_Driver model where model.statusEnabled=true and model.authCode=:authCode ")
    T_Driver getOneByAuthCode(@Param("authCode") String authCode);
    
    @Query("select new map ("
            + "a.code as code,"
            + "a.driver as driver,"
            + "a.identityNumber as identityNumber,"
            + "a.birtPlace as birtPlace,"
            + "a.birtDate as birtDate,"
            + "a.phoneNumber as phoneNumber,"
            + "a.companyCode as companyCode,"
            + "a.image as image,"
            + "b.id as genderId,"
            + "b.gender as gender,"
            + "c.id as religionId,"
            + "c.religion as religion) "
            + "from T_Driver a "
            + "left join a.gender b "
            + "left join a.religion c "
            + "where a.statusEnabled=true "
            + "and a.code=:code ")
    Map getOneByCode(@Param("code") String code);
    
}
