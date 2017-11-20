package com.microservice.erp2017.controller;

import com.microservice.erp2017.model.vo.VO_M_Religion;
import com.microservice.erp2017.model.vo.VO_T_Company;
import com.microservice.erp2017.service.ReligionService;
import com.microservice.erp2017.util.RestUtil;
import io.swagger.annotations.ApiOperation;
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
 * @author reza
 */
@RestController
@RequestMapping("/religion")
public class ReligionController extends RestUtil{
    
    @Autowired
    private ReligionService religionService;
    
    @ApiOperation("Api for save Religion")
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody VO_M_Religion vo) {
        return setResponse200(religionService.save(vo));
    }
    
    @ApiOperation("Api for update Religion")
    @PostMapping("/update")
    public ResponseEntity update(@Valid @RequestBody VO_M_Religion vo) {
        return setResponse200(religionService.update(vo));
    }
    
    @ApiOperation("Api for delete Religion")
    @GetMapping("/delete")
    public ResponseEntity delete(@Valid @RequestParam Integer primary) {
        return setResponse200(religionService.delete(primary));
    }
}
