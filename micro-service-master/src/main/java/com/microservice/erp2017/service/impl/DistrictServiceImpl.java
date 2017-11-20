package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_District;
import com.microservice.erp2017.model.vo.VO_M_District;
import com.microservice.erp2017.service.DistrictService;
import com.microservice.erp2017.service.repo.DistrictRepo;
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
@Service("DistrictService")
public class DistrictServiceImpl implements DistrictService{
    
    @Autowired
    private DistrictRepo districtRepo;

    @Override
    public Map save(VO_M_District vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_District district = new M_District();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, district);
            //------------------------------------------------------------------
            resultMap.put("result", districtRepo.save(district).getDistrict());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_District vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_District district = districtRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, district);
            //------------------------------------------------------------------
            resultMap.put("result", districtRepo.save(district).getDistrict());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_District district = districtRepo.findOne(primary);
            //------------------------------------------------------------------
            district.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", districtRepo.save(district).getDistrict());
        }
        
        return resultMap;
    }
    
}
