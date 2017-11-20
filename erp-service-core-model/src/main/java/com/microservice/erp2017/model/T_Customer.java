package com.microservice.erp2017.model;

import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.COLUMN_NOT_NULL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Reza
 */
@Getter
@Setter
@Entity
@Table(name="T_Customer")
public class T_Customer extends BaseTransaction{
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="customer", length=50, nullable=false)
    private String customer;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="authCode", insertable=false, updatable=false)
    private T_Auth auth;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="authCode", nullable=false)
    private String authCode;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="phoneNumber", length=25, nullable=false)
    private String phoneNumber;
    
    @Column(name="image")
    private byte[] image;
}
