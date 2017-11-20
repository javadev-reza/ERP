package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_City;
import com.microservice.erp2017.model.M_Label;
import com.microservice.erp2017.model.vo.VO_M_City;
import com.microservice.erp2017.model.vo.VO_M_Label;
import com.microservice.erp2017.service.CityService;
import com.microservice.erp2017.service.LabelService;
import com.microservice.erp2017.service.repo.CityRepo;
import com.microservice.erp2017.service.repo.LabelRepo;
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
@Service("LabelService")
public class LabelServiceImpl implements LabelService{
    
    @Autowired
    private LabelRepo labelRepo;

    @Override
    public Map save(VO_M_Label vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Label label = new M_Label();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, label);
            //------------------------------------------------------------------
            resultMap.put("result", labelRepo.save(label).getLabel());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_Label vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Label label = labelRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, label);
            //------------------------------------------------------------------
            resultMap.put("result", labelRepo.save(label).getLabel());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_Label label = labelRepo.findOne(primary);
            //------------------------------------------------------------------
            label.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", labelRepo.save(label).getLabel());
        }
        
        return resultMap;
    }
    
}
