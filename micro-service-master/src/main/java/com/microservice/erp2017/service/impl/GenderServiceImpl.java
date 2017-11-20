package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_Gender;
import com.microservice.erp2017.model.vo.VO_M_Gender;
import com.microservice.erp2017.service.GenderService;
import com.microservice.erp2017.service.repo.GenderRepo;
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
@Service("GenderService")
public class GenderServiceImpl implements GenderService{
    
    @Autowired
    private GenderRepo genderRepo;

    @Override
    public Map save(VO_M_Gender vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Gender gender = new M_Gender();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, gender);
            //------------------------------------------------------------------
            resultMap.put("result", genderRepo.save(gender).getGender());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_Gender vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Gender gender = genderRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, gender);
            //------------------------------------------------------------------
            resultMap.put("result", genderRepo.save(gender).getGender());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_Gender gender = genderRepo.findOne(primary);
            //------------------------------------------------------------------
            gender.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", genderRepo.save(gender).getGender());
        }
        
        return resultMap;
    }
    
}
