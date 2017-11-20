package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_Modul;
import com.microservice.erp2017.model.vo.VO_M_Modul;
import com.microservice.erp2017.service.ModulService;
import com.microservice.erp2017.service.repo.ModulRepo;
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
@Service("ModulService")
public class ModulServiceImpl implements ModulService{
    
    @Autowired
    private ModulRepo modulRepo;

    @Override
    public Map save(VO_M_Modul vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Modul modul = new M_Modul();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, modul);
            //------------------------------------------------------------------
            resultMap.put("result", modulRepo.save(modul).getModul());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_Modul vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Modul modul = modulRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, modul);
            //------------------------------------------------------------------
            resultMap.put("result", modulRepo.save(modul).getModul());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_Modul modul = modulRepo.findOne(primary);
            //------------------------------------------------------------------
            modul.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", modulRepo.save(modul).getModul());
        }
        
        return resultMap;
    }
    
}
