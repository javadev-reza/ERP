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
public class VO_T_Company extends BaseTransactionVO{
    
    private String ownerName;
    
    private String companyName;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String authCode;
    
    private byte[] image;

    private VO_T_CompanyAddress address;
}
