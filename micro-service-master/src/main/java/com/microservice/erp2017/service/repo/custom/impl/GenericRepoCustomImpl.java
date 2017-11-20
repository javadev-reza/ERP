package com.microservice.erp2017.service.repo.custom.impl;

import com.microservice.erp2017.service.repo.custom.GenericRepoCustom;
import com.microservice.erp2017.util.CommonUtil;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reza
 */
@Repository("GenericRepoCustom")
public class GenericRepoCustomImpl implements GenericRepoCustom {
    
    @PersistenceContext 
    private EntityManager em;
    
    @Override
    public List<Map> getGenericModel(
            Integer rowStart, Integer size, String className, String fields, String criteria, String value){
        String result;
        //----------------------------------------------------------------------
        StringBuilder property = new StringBuilder();
        String[] field = fields.split(",");
        for(String f : field){
            property.append("model.").append(f).append(" as ").append(f).append(",");
        }
        //----------------------------------------------------------------------
        StringBuilder buffer = new StringBuilder();
        buffer.append("select new map")
              .append("(").append(property.substring(0, property.length()-1)).append(") ")
              .append("from ").append(className).append(" model ");
        //----------------------------------------------------------------------
        if(CommonUtil.isNotNullOrEmpty(criteria)){
            buffer.append("where ")
            .append("model.statusEnabled=true and ");
            //------------------------------------------------------------------
            StringBuilder crit = new StringBuilder();
            String[] cri = criteria.split(",");
            //------------------------------------------------------------------
            if(CommonUtil.isNotNullOrEmpty(value)){
                String[] val = value.split(",");
                //--------------------------------------------------------------
                int i=0;
                for(String cr : cri){
                    if(cr.endsWith("like")){
                        String likeVal = "'%"+val[i]+"%'";
                        crit.append("model.")
                            .append(cr)
                            .append(" ")
                            .append(likeVal)
                            .append(" and ");
                    } else{
                        crit.append("model.")
                            .append(cr)
                            .append("=")
                            .append(val[i])
                            .append(" and ");
                    }
                    i++;
                }
            }
            buffer.append(crit);
            //------------------------------------------------------------------
            result = buffer.substring(0, buffer.length()-4);
        } else{
            result = buffer.toString();
        }
        //----------------------------------------------------------------------
        Query query = em.createQuery(result);
        //----------------------------------------------------------------------
        if(CommonUtil.isNotNullOrEmpty(rowStart)) {
            query.setFirstResult(rowStart);
        }
        if(CommonUtil.isNotNullOrEmpty(size)) {
            query.setMaxResults(size);
        }
        return query.getResultList();
    }
    
    @Override
    public Integer getCountGenericModel(
            String className, String criteria, String value){
        String result;
        //----------------------------------------------------------------------
        StringBuilder buffer = new StringBuilder();
        buffer.append("select count(model.id) ")
              .append("from ").append(className).append(" model ");
        //----------------------------------------------------------------------
        if(CommonUtil.isNotNullOrEmpty(criteria)){
            buffer.append("where ")
            .append("model.statusEnabled=true and ");
            //------------------------------------------------------------------
            StringBuilder crit = new StringBuilder();
            String[] cri = criteria.split(",");
            //------------------------------------------------------------------
            if(CommonUtil.isNotNullOrEmpty(value)){
                String[] val = value.split(",");
                //--------------------------------------------------------------
                int i=0;
                for(String cr : cri){
                    if(cr.endsWith("like")){
                        String likeVal = "'%"+val[i]+"%'";
                        crit.append("model.")
                            .append(cr)
                            .append(" ")
                            .append(likeVal)
                            .append(" and ");
                    } else{
                        crit.append("model.")
                            .append(cr)
                            .append("=")
                            .append(val[i])
                            .append(" and ");
                    }
                    i++;
                }
            }
            buffer.append(crit);
            //------------------------------------------------------------------
            result = buffer.substring(0, buffer.length()-4);
        } else{
            result = buffer.toString();
        }
        //----------------------------------------------------------------------
        Query query = em.createQuery(result);
        //----------------------------------------------------------------------
        return ((Long) query.getSingleResult()).intValue();
    }
    
    @Override
    public Integer[] paging(Integer page, Integer size, Integer totalSize) {
    	Integer[] result = new Integer[4];
    	int totalPages = 0;
        int pageRequested = page;
        if (totalSize > 0) {
            totalPages = (int) Math.ceil((double) totalSize / (double) size);
        } else {
            totalPages = 0;
	}
	if (pageRequested > totalPages)
            pageRequested = totalPages;
	int rowStart = pageRequested * size - size;
	if (rowStart < 0) {
            rowStart = 0;
	}
	result[0] = rowStart;
	result[1] = size;
	result[2] = totalSize;
	result[3] = totalPages;
    	return result;
    }
}
