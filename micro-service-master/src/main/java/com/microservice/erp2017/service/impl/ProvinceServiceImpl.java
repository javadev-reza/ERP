package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_Province;
import com.microservice.erp2017.model.vo.VO_M_Province;
import com.microservice.erp2017.service.ProvinceService;
import com.microservice.erp2017.service.repo.ProvinceRepo;
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
@Service("ProvinceService")
public class ProvinceServiceImpl implements ProvinceService{
    
    @Autowired
    private ProvinceRepo provinceRepo;

    @Override
    public Map save(VO_M_Province vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Province province = new M_Province();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, province);
            //------------------------------------------------------------------
            resultMap.put("result", provinceRepo.save(province).getProvince());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_Province vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Province province = provinceRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, province);
            //------------------------------------------------------------------
            resultMap.put("result", provinceRepo.save(province).getProvince());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_Province province = provinceRepo.findOne(primary);
            //------------------------------------------------------------------
            province.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", provinceRepo.save(province).getProvince());
        }
        
        return resultMap;
    }
    
}
