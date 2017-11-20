package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_SubDistrict;
import com.microservice.erp2017.model.vo.VO_M_SubDistrict;
import com.microservice.erp2017.service.SubDistrictService;
import com.microservice.erp2017.service.repo.SubDistrictRepo;
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
@Service("SubDistrictService")
public class SubDistrictServiceImpl implements SubDistrictService{
    
    @Autowired
    private SubDistrictRepo subDistrictRepo;

    @Override
    public Map save(VO_M_SubDistrict vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_SubDistrict subDistrict = new M_SubDistrict();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, subDistrict);
            //------------------------------------------------------------------
            resultMap.put("result", subDistrictRepo.save(subDistrict).getDistrict());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_SubDistrict vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_SubDistrict subDistrict = subDistrictRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, subDistrict);
            //------------------------------------------------------------------
            resultMap.put("result", subDistrictRepo.save(subDistrict).getDistrict());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_SubDistrict subDistrict = subDistrictRepo.findOne(primary);
            //------------------------------------------------------------------
            subDistrict.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", subDistrictRepo.save(subDistrict).getDistrict());
        }
        
        return resultMap;
    }
    
}
