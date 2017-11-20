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
@Table(name="M_Province")
public class M_Province extends BaseMaster {
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="countryId", insertable=false, updatable=false)
    private M_Country country;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="countryId", nullable=false)
    private Integer countryId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="province", length=50, nullable=false)
    private String province;

}
