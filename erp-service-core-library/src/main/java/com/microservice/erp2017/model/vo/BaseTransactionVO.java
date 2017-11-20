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
public class BaseTransactionVO {
    
    private String code;
    
    private Boolean statusEnabled;
}
