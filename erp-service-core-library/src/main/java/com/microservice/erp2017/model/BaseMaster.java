package com.microservice.erp2017.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Reza
 */
@SuppressWarnings("serial")
@Getter
@Setter
@MappedSuperclass
public class BaseMaster extends BaseTemp implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "statusEnabled", nullable=true)
    private Boolean statusEnabled;
    
    @Column(name="description", length=100, nullable=true)
    private String description;
}
