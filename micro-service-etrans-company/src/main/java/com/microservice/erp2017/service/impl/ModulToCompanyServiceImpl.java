package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.BaseServiceImpl;
import com.microservice.erp2017.model.T_ModulToCompany;
import com.microservice.erp2017.model.vo.VO_T_ModulToCompany;
import com.microservice.erp2017.service.ModulToCompanyService;
import com.microservice.erp2017.service.repo.ModulToCompanyRepo;
import com.microservice.erp2017.util.CommonUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author reza
 */
@Service("ModulToCompanyService")
public class ModulToCompanyServiceImpl extends BaseServiceImpl implements ModulToCompanyService{

    @Autowired
    private ModulToCompanyRepo modulToCompanyRepo;
    
    @Override
    public List<Map<String, Object>> getModulByCompanyCode(String companyCode){
        return modulToCompanyRepo.getModulByCompanyCode(companyCode);
    }
    
    @Override
    public List<Map<String, Object>> getApplicationByModulId(Integer modulId){
        return modulToCompanyRepo.getApplicationByModulId(modulId);
    }
    
    @Override
    public Map save(VO_T_ModulToCompany vo) {
        Map<String, Object> resultMap = new HashMap<>();
        //----------------------------------------------------------------------
        if(CommonUtil.isNotNullOrEmpty(vo)){
            
            T_ModulToCompany modulToCompany = new T_ModulToCompany();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, modulToCompany);
            //------------------------------------------------------------------
            if(CommonUtil.isNotNullOrEmpty(modulToCompany)){
                resultMap.put("result", modulToCompanyRepo.save(modulToCompany).getCode());
            }
        }
        return resultMap;
    }

    @Override
    public Map update(VO_T_ModulToCompany vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map delete(String primary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map getOne(String primary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map getAll(Pageable page, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
