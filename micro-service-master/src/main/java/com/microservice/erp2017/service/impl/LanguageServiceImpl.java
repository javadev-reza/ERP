package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_Language;
import com.microservice.erp2017.model.vo.VO_M_Language;
import com.microservice.erp2017.service.LanguageService;
import com.microservice.erp2017.service.repo.LanguageRepo;
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
@Service("LanguageService")
public class LanguageServiceImpl implements LanguageService{
    
    @Autowired
    private LanguageRepo languageRepo;

    @Override
    public Map save(VO_M_Language vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Language language = new M_Language();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, language);
            //------------------------------------------------------------------
            resultMap.put("result", languageRepo.save(language).getLanguage());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_Language vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Language language = languageRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, language);
            //------------------------------------------------------------------
            resultMap.put("result", languageRepo.save(language).getLanguage());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_Language language = languageRepo.findOne(primary);
            //------------------------------------------------------------------
            language.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", languageRepo.save(language).getLanguage());
        }
        
        return resultMap;
    }
    
}
