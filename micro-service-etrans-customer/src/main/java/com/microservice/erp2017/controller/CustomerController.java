package com.microservice.erp2017.controller;

import com.microservice.erp2017.model.vo.VO_T_Customer;
import com.microservice.erp2017.service.CustomerService;
import com.microservice.erp2017.util.RestUtil;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reza
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends RestUtil{
    
    @Autowired CustomerService customerService;

    @ApiOperation("Api for save Customer")
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody VO_T_Customer vo, HttpServletResponse httpResponse) {
        return setResponse200(customerService.save(vo));
    }
    
    @ApiOperation("Api for Customer getOne")
    @GetMapping("/get-one")
    public ResponseEntity getOne(@Valid @RequestParam String primary, HttpServletResponse httpResponse) {
        return setResponse200(customerService.getOne(primary));
    }
    
    @ApiOperation("Api for Customer getAll")
    @GetMapping("/get-all")
    public ResponseEntity getAll(HttpServletResponse httpResponse) {
        return null;
    }
    
}
