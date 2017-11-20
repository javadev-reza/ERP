package com.microservice.erp2017.model;

import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.COLUMN_NOT_NULL;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="M_Religion")
public class M_Religion extends BaseMaster{
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="religion", length=20, nullable=false)
    private String religion;
}
