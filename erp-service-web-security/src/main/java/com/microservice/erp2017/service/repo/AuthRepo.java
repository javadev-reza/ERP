package com.microservice.erp2017.service.repo;

import com.microservice.erp2017.model.T_Auth;
import com.microservice.erp2017.model.T_Company;
import com.microservice.erp2017.model.T_Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reza
 */
@Repository("AuthRepo")
public interface AuthRepo extends JpaRepository<T_Auth, String>{
    
    @Query("select model from T_Auth model where model.userName=:userName")
    T_Auth loadUserByUsername(@Param("userName") String userName);
    
    @Query("select model from T_Company model where model.code=:code and model.authCode=:authCode")
    T_Company getCompany(@Param("code") String code, @Param("authCode") String authCode);
    
    @Query("select model from T_Employee model where model.companyCode=:companyCode and model.authCode=:authCode")
    T_Employee getEmployee(@Param("companyCode") String companyCode, @Param("authCode") String authCode);
}
