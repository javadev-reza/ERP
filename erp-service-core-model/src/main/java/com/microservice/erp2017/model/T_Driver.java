package com.microservice.erp2017.model;

import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.COLUMN_NOT_NULL;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
@Table(name="T_Driver")
public class T_Driver extends BaseTransaction{
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="driver", length=50, nullable=false)
    private String driver;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="genderId", insertable=false, updatable=false)
    private M_Gender gender;
    
    @Column(name="genderId", nullable=true)
    private Integer genderId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="identityNumber", length=50, nullable=false)
    private String identityNumber;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="birtPlace", length=50, nullable=false)
    private String birtPlace;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="birtDate", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birtDate;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="religionId", insertable=false, updatable=false)
    private M_Religion religion;
    
    @Column(name="religionId", nullable=true)
    private Integer religionId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="phoneNumber", length=25, nullable=false)
    private String phoneNumber;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="authCode", insertable=false, updatable=false)
    private T_Auth auth;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="authCode", nullable=false)
    private String authCode;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="companyCode", insertable=false, updatable=false)
    private T_Company company;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="companyCode", nullable=false)
    private String companyCode;
    
    @Column(name="image")
    private byte[] image;
    
}
