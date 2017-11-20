package com.microservice.erp2017.controller;

import com.microservice.erp2017.model.vo.VO_T_Company;
import com.microservice.erp2017.util.RestUtil;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.erp2017.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Reza
 */
@RestController
@RequestMapping("/company")
public class CompanyController extends RestUtil{
    
    @Autowired 
    private CompanyService companyService;

    @ApiOperation("Api for save Company")
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody VO_T_Company vo, HttpServletResponse httpResponse) {
        return setResponse200(companyService.save(vo));
    }
    
    @ApiOperation("Api for save Company getOne")
    @GetMapping("/get-one")
    public ResponseEntity getOne(@Valid @RequestParam String primary, HttpServletResponse httpResponse) {
        return setResponse200(companyService.getOne(primary));
    }
}
