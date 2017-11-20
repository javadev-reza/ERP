package com.microservice.erp2017.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.erp2017.model.vo.VO_T_Driver;
import com.microservice.erp2017.util.RestUtil;
import io.swagger.annotations.ApiOperation;
import com.microservice.erp2017.service.DriverService;

/**
 *
 * @author Reza
 */
@RestController
@RequestMapping("/driver")
public class DriverController extends RestUtil{

    @Autowired DriverService driverService;
	
    @ApiOperation("Api for save Driver")
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody VO_T_Driver vo, HttpServletResponse httpResponse) {
        return setResponse200(driverService.save(vo));
    }
}
