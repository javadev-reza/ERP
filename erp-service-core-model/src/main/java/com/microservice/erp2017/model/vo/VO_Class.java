package com.microservice.erp2017.model.vo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author reza
 */
@Getter
@Setter
public class VO_Class {
    
    private String className;
    
    private List<VO_Property> properties;
}
