package com.microservice.erp2017.model.vo;

import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.COLUMN_NOT_NULL;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Reza
 */
@Getter
@Setter
public class VO_T_Customer extends BaseTransactionVO{
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String customer;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String authCode;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String phoneNumber;
    
    private byte[] image;
}
