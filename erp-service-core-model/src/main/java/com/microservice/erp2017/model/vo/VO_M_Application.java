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
public class VO_M_Application extends BaseMasterVO{
    
    @NotNull(message=COLUMN_NOT_NULL)
    private Integer modulId;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String application;
    
    @NotNull(message=COLUMN_NOT_NULL)
    private String link;
    
    private Double price;
}
