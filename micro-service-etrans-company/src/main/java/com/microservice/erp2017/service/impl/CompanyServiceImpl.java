package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.BaseServiceImpl;
import com.microservice.erp2017.model.T_Auth;
import com.microservice.erp2017.model.T_Company;
import com.microservice.erp2017.model.vo.VO_T_Company;
import com.microservice.erp2017.model.vo.VO_T_CompanyAddress;
import com.microservice.erp2017.model.vo.VO_T_ModulToCompany;
import com.microservice.erp2017.service.AuthService;
import com.microservice.erp2017.service.CompanyAddressService;
import com.microservice.erp2017.service.CompanyService;
import com.microservice.erp2017.service.EmailService;
import com.microservice.erp2017.service.ModulToCompanyService;
import com.microservice.erp2017.util.CommonUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.erp2017.service.repo.CompanyRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Reza
 */
@Service("CompanyService")
public class CompanyServiceImpl extends BaseServiceImpl implements CompanyService{
    
    @Autowired
    private CompanyRepo companyRepo;
    
    @Autowired
    private CompanyAddressService companyAddressService;
    
    @Autowired
    private ModulToCompanyService modulToCompanyService;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private AuthService authService;

    @Override
    public T_Company getOneByAuthCode(String authCode){
        T_Company resultData = companyRepo.getOneByAuthCode(authCode);
        if(CommonUtil.isNotNullOrEmpty(resultData)){
            return resultData; 
        } else{
            return null;
        }
    }
    
    @Transactional(readOnly = false)
    private void saveCompanyAddress(VO_T_CompanyAddress vo, String companyCode){
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            VO_T_CompanyAddress companyAddressVo = new VO_T_CompanyAddress();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, companyAddressVo);
            //------------------------------------------------------------------
            companyAddressVo.setCompanyCode(companyCode);
            //------------------------------------------------------------------
            companyAddressService.save(companyAddressVo);
        }
    }
    
    @Transactional(readOnly = false)
    private void saveModulToCompany(String companyCode){
        
        if(CommonUtil.isNotNullOrEmpty(this)){
            VO_T_ModulToCompany modulToCompanyVo = new VO_T_ModulToCompany();
            //------------------------------------------------------------------
            modulToCompanyVo.setModulId(1);
            //------------------------------------------------------------------
            modulToCompanyVo.setCompanyCode(companyCode);
            //------------------------------------------------------------------
            modulToCompanyVo.setStatusEnabled(true);
            //------------------------------------------------------------------
            modulToCompanyService.save(modulToCompanyVo);
            //------------------------------------------------------------------
        }
    }
    
    @Transactional(readOnly = false)
    private void sendActivationCode(String companyCode, String authCode){
        T_Auth auth = authService.getOneByCode(authCode);
        
        if(CommonUtil.isNotNullOrEmpty(auth)){
            emailService.sendEmail(companyCode, auth.getUserName());
        }
    }
    
    @Override
    @Transactional(readOnly = false)
    public Map save(VO_T_Company vo) {
        Map<String, Object> resultMap = new HashMap<>();

        if(CommonUtil.isNotNullOrEmpty(vo)){

            T_Company resultData = getOneByAuthCode(vo.getAuthCode());
            //------------------------------------------------------------------
            if(CommonUtil.isNullOrEmpty(resultData)){
                
                T_Company company = new T_Company();
                //--------------------------------------------------------------
                BeanUtils.copyProperties(vo, company);
                //--------------------------------------------------------------
                company.setAuthCode(vo.getAuthCode());
                
                if(CommonUtil.isNotNullOrEmpty(company)){
                    
                    T_Company companyResult = companyRepo.save(company);
                    //----------------------------------------------------------
                    if(CommonUtil.isNotNullOrEmpty(companyResult)){
                        //------------------------------------------------------
                        if(CommonUtil.isNotNullOrEmpty(vo.getAddress())){
                            saveCompanyAddress(vo.getAddress(), companyResult.getCode());
                        }
                        //------------------------------------------------------
                        if(CommonUtil.isNotNullOrEmpty(companyResult.getCode())){
                            saveModulToCompany(companyResult.getCode());
                        }
                         //------------------------------------------------------
                        if(CommonUtil.isNotNullOrEmpty(companyResult.getCode())){
                            sendActivationCode(companyResult.getCode(), vo.getAuthCode());
                        }
                        //------------------------------------------------------
                        resultMap.put("result", companyResult.getCode());
                    }
                }
            }
        }
        return resultMap;
    }

    @Override
    public Map update(VO_T_Company vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map delete(String primary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map getOne(String primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        Map<String, Object> company = companyRepo.getOneByCode(primary);
        //----------------------------------------------------------------------
        List<Map<String, Object>> moduls = new ArrayList<>();
        //----------------------------------------------------------------------
        if(CommonUtil.isNotNullOrEmpty(company)){
            
            for(Map<String, Object> modul : modulToCompanyService.getModulByCompanyCode((String) company.get("code"))){
                if(CommonUtil.isNotNullOrEmpty(modul)){
                    modul.put("applications", modulToCompanyService.getApplicationByModulId((Integer) modul.get("modulId")));
                }
                moduls.add(modul);
            }
        }
        
        if(CommonUtil.isNotNullOrEmpty(moduls)){
            resultMap.put("company", company);
            resultMap.put("moduls", moduls);
        }
        
        return resultMap;
    }

    @Override
    public Map getAll(Pageable page, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
