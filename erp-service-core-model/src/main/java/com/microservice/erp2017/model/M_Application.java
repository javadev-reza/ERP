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
@Table(name="M_Application")
public class M_Application extends BaseMaster{
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="modulId", insertable=false, updatable=false)
    private M_Modul modul;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="modulId", nullable=false)
    private Integer modulId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="application", length=50, nullable=false)
    private String application;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="link", length=50, nullable=false)
    private String link;
    
    @Column(name="price", nullable=true)
    private Double price;
}
