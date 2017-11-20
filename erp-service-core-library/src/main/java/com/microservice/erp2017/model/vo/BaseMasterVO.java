package com.microservice.erp2017.model.vo;

import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Reza
 */
@Getter
@Setter
@MappedSuperclass
public class BaseMasterVO {
    
    private Integer id;
    
    private Boolean statusEnabled;
}
