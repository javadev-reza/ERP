package com.microservice.erp2017.model;

import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.COLUMN_NOT_NULL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="M_SubDistrict")
public class M_SubDistrict extends BaseMaster{
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="districtId", insertable=false, updatable=false)
    private M_District district;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="districtId", nullable=false)
    private Integer districtId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="subDistrict", length=50, nullable=false)
    private String subDistrict;
}
