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
@Table(name="M_City")
public class M_City extends BaseMaster{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="provinceId", insertable=false, updatable=false)
    private M_Province province;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="provinceId", nullable=false)
    private Integer provinceId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="city", length=50, nullable=false)
    private String city;

}
