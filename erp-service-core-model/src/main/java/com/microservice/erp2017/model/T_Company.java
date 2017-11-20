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
@Table(name="T_Company")
public class T_Company extends BaseTransaction{
    
    @Column(name="ownerName", length=50, nullable=false)
    private String ownerName;
    
    @Column(name="companyName", length=50, nullable=false)
    private String companyName;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="authCode", insertable=false, updatable=false)
    private T_Auth auth;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="authCode", nullable=false)
    private String authCode;
    
    @Column(name="image")
    private byte[] image;

}
