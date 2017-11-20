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
public class VO_T_CompanyAddress extends BaseTransactionVO {
    
    private String companyCode;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String address;
    
    private String postalCode;
    
    private Integer countryId;
    
    private Integer provinceId;
    
    private Integer cityId;
    
    private Integer districtId;
    
    private Integer subDistrictId;

}
