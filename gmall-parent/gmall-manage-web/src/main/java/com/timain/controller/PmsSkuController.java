package com.timain.controller;

import com.timain.pojo.PmsSkuInfo;
import com.timain.service.PmsSkuInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 17:18
 */
@RestController
@CrossOrigin
public class PmsSkuController {
    
    @Reference
    private PmsSkuInfoService pmsSkuInfoService;
    
    @RequestMapping("saveSkuInfo")
    public void saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        this.pmsSkuInfoService.insertSkuInfo(pmsSkuInfo);
    }
}
