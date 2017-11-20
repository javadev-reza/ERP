package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_Religion;
import com.microservice.erp2017.model.vo.VO_M_Religion;
import com.microservice.erp2017.service.ReligionService;
import com.microservice.erp2017.service.repo.ReligionRepo;
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
@Service("ReligionService")
public class ReligionServiceImpl implements ReligionService{
    
    @Autowired
    private ReligionRepo religionRepo;

    @Override
    public Map save(VO_M_Religion vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Religion religion = new M_Religion();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, religion);
            //------------------------------------------------------------------
            resultMap.put("result", religionRepo.save(religion).getReligion());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_Religion vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Religion religion = religionRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, religion);
            //------------------------------------------------------------------
            resultMap.put("result", religionRepo.save(religion).getReligion());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_Religion religion = religionRepo.findOne(primary);
            //------------------------------------------------------------------
            religion.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", religionRepo.save(religion).getReligion());
        }
        
        return resultMap;
    }
    
}
