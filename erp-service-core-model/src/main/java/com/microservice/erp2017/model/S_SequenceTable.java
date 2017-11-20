package com.microservice.erp2017.model;

import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.COLUMN_NOT_NULL;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "S_SequenceTable")
public class S_SequenceTable extends BaseMaster{

    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="tableName",length=50, nullable=false)
    private String tableName;

    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name = "lastPrimary", nullable=false)
    private Integer lastPrimary;
   
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="inputDate", nullable=false)
    private Date inputDate;

}
