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
@Table(name="T_Auth")
public class T_Auth extends BaseTransaction{
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="authStatusId", insertable=false, updatable=false)
    private S_AuthStatus authStatus;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="authStatusId", nullable=false)
    private Integer authStatusId;

    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="userName", length=50, nullable=false)
    private String userName;
    
    @NotNull(message=COLUMN_NOT_NULL)
    @Column(name="password", length=50, nullable=false)
    private String password;
    
}
