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
@Table(name="M_District")
public class M_District extends BaseMaster{
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cityId", insertable=false, updatable=false)
    private M_City city;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="cityId", nullable=false)
    private Integer cityId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="district", length=50, nullable=false)
    private String district;
}
