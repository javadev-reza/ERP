package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.T_Customer;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reza
 */
@Repository("CustomerRepo")
public interface CustomerRepo extends JpaRepository<T_Customer, String>{
    
    @Query("select model from T_Customer model where model.statusEnabled=true and model.authCode=:authCode ")
    T_Customer getOneByAuthCode(@Param("authCode") String authCode);
    
    @Query("select new map ("
            + "a.code as code,"
            + "a.customer as customer,"
            + "a.phoneNumber as phoneNumber,"
            + "a.image as image) "
            + "from T_Customer a "
            + "where a.statusEnabled=true "
            + "and a.code=:code ")
    Map getOneByCode(@Param("code") String code);
    
    @Query("select new map ("
            + "a.code as code,"
            + "a.customer as customer,"
            + "a.phoneNumber as phoneNumber,"
            + "a.image as image) "
            + "from T_Customer a "
            + "where a.statusEnabled=true ")
    List<Map> getAll();
    
}
