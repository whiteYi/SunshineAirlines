package com.wtbu.springbootsunshineairlines.Controller;

import com.wtbu.springbootsunshineairlines.Service.CityService;
import com.wtbu.springbootsunshineairlines.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CityController {

    @Resource
    private CityService cityService;

    @RequestMapping(value = "/getCityNames")
    public Object getCityNames() {
        Result result = cityService.getCityNames();
        return result;
    }

}
