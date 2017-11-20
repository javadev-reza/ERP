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
@Table(name="T_EmployeeAddress")
public class T_EmployeeAddress extends BaseTransaction {
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employeeCode", insertable=false, updatable=false)
    private T_Employee employee;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="employeeCode", nullable=false)
    private String employeeCode;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="address", length=200, nullable=false)
    private String address;
    
    @Column(name="postalCode", length=25, nullable=true)
    private String postalCode;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="countryId", insertable=false, updatable=false)
    private M_Country country;
    
    @Column(name="countryId", nullable=true)
    private Integer countryId;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="provinceId", insertable=false, updatable=false)
    private M_Province province;
    
    @Column(name="provinceId", nullable=true)
    private Integer provinceId;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cityId", insertable=false, updatable=false)
    private M_City city;
    
    @Column(name="cityId", nullable=true)
    private Integer cityId;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="districtId", insertable=false, updatable=false)
    private M_District district;
    
    @Column(name="districtId", nullable=true)
    private Integer districtId;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="subDistrictId", insertable=false, updatable=false)
    private M_SubDistrict subDistrict;
    
    @Column(name="subDistrictId", nullable=true)
    private Integer subDistrictId;

}
