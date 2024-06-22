package ynu.edu.controller;


import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ynu.edu.entity.Business;
import ynu.edu.service.impl.businessInfoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessInfoController {
    @Resource
    private businessInfoServiceImpl businessInfoService;
    @GetMapping("/getbusinessinfo")
    public List<Business> pushBusinessInfo(){
        return businessInfoService.selectBusinessInfo();
    }
}
