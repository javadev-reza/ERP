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
public class VO_M_City extends BaseMasterVO{

    @NotNull(message=COLUMN_NOT_NULL)
    private Integer provinceId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String city;

}
