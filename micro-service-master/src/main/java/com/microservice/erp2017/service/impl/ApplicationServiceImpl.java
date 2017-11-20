package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_Application;
import com.microservice.erp2017.model.vo.VO_M_Application;
import com.microservice.erp2017.service.ApplicationService;
import com.microservice.erp2017.service.repo.ApplicationRepo;
import com.microservice.erp2017.util.CommonUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author reza
 */
@Service("ApplicationService")
public class ApplicationServiceImpl implements ApplicationService{
    
    @Autowired
    private ApplicationRepo applicationRepo;

    @Override
    public Map save(VO_M_Application vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Application application = new M_Application();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, application);
            //------------------------------------------------------------------
            resultMap.put("result", applicationRepo.save(application).getApplication());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_Application vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Application application = applicationRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, application);
            //------------------------------------------------------------------
            resultMap.put("result", applicationRepo.save(application).getApplication());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_Application application = applicationRepo.findOne(primary);
            //------------------------------------------------------------------
            application.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", applicationRepo.save(application).getApplication());
        }
        
        return resultMap;
    }
    
}
