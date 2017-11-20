package com.microservice.erp2017.model.vo;

import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.COLUMN_NOT_NULL;
import java.util.Date;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Reza
 */
@Getter
@Setter
public class VO_T_Driver extends BaseTransactionVO{
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String driver;
    
    private Integer genderId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String identityNumber;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String birtPlace;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private Date birtDate;
    
    private Integer religionId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String phoneNumber;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String authCode;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String companyCode;
    
    @Column(name="image")
    private byte[] image;
    
    private VO_T_DriverAddress address;
    
}
