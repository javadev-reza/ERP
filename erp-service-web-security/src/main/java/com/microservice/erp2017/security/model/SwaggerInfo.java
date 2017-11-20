package com.microservice.erp2017.security.model;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

/**
 *
 * @author Reza
 */
public class SwaggerInfo{
    
    public ApiInfo apiInfoAuth() {
        return new ApiInfoBuilder()
        .title("ERP Service Authentication - API Documentation")
        .description("------------------------------------------------------")
        .contact(": Reza Fauzan")
        .version("ERP Service Version 1.0")
        .build();
    }
    
    public ApiInfo apiInfoEtrans() {
        return new ApiInfoBuilder()
        .title("ERP Service Etrans - API Documentation")
        .description("------------------------------------------------------")
        .contact(": Reza Fauzan")
        .version("ERP Service Version 1.0")
        .build();
    }
    
    public ApiInfo apiInfoMaster() {
        return new ApiInfoBuilder()
        .title("ERP Service Master - API Documentation")
        .description("------------------------------------------------------")
        .contact(": Reza Fauzan")
        .version("ERP Service Version 1.0")
        .build();
    }
}
