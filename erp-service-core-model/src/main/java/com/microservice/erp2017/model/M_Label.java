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
 * @author reza
 */
@Getter
@Setter
@Entity
@Table(name="M_Label")
public class M_Label extends BaseMaster{
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="languageId", insertable=false, updatable=false)
    private M_Language language;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="languageId", nullable=false)
    private Integer languageId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="label", length=50, nullable=false)
    private String label;
    
}
