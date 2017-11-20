package com.microservice.erp2017.controller;

import com.microservice.erp2017.util.RestUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.erp2017.service.GenericService;

/**
 *
 * @author reza
 */
@RestController
@RequestMapping("/generic")
public class GenericController extends RestUtil{
    
    @Autowired 
    private GenericService religionService;
     
    @ApiOperation("Api for List generic")
    @GetMapping("/list-generic")
    public ResponseEntity listGeneric(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
	    @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "className", required = false) String className,
	    @RequestParam(value = "fields", required = false) String fields,
            @RequestParam(value = "criteria", required = false) String criteria,
            @RequestParam(value = "value", required = false) String value) {
        return setResponse200(religionService.getAll(page, size, className, fields, criteria, value));
    }

}
