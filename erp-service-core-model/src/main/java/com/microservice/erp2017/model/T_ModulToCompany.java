package com.microservice.erp2017.model;

import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.COLUMN_NOT_NULL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name="T_ModulToCompany")
public class T_ModulToCompany extends BaseTransaction{
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="modulId", insertable=false, updatable=false)
    private M_Modul modul;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="modulId", nullable=false)
    private Integer modulId;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="companyCode", insertable=false, updatable=false)
    private T_Company company;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="companyCode", nullable=false)
    private String companyCode;
}
