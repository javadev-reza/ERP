package com.microservice.erp2017.controller;

import com.microservice.erp2017.model.vo.VO_M_Gender;
import com.microservice.erp2017.service.GenderService;
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
@RequestMapping("/gender")
public class GenderController extends RestUtil{
    
    @Autowired
    private GenderService genderService;
    
    @ApiOperation("Api for save Gender")
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody VO_M_Gender vo) {
        return setResponse200(genderService.save(vo));
    }
    
    @ApiOperation("Api for update Gender")
    @PostMapping("/update")
    public ResponseEntity update(@Valid @RequestBody VO_M_Gender vo) {
        return setResponse200(genderService.update(vo));
    }
    
    @ApiOperation("Api for delete Gender")
    @GetMapping("/delete")
    public ResponseEntity delete(@Valid @RequestParam Integer primary) {
        return setResponse200(genderService.delete(primary));
    }
}
