package com.timain.controller;

import com.timain.pojo.PmsBaseSaleAttr;
import com.timain.pojo.PmsProductInfo;
import com.timain.service.PmsBaseSaleAttrService;
import com.timain.service.PmsProductInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/17 15:18
 */
@RestController
@CrossOrigin
public class PmsProductInfoController {
    
    @Reference
    private PmsProductInfoService pmsProductInfoService;
    @Reference
    private PmsBaseSaleAttrService pmsBaseSaleAttrService;
    
    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(Long catalog3Id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("catalog3_id", catalog3Id);
        return pmsProductInfoService.listByMap(map);
    }
    
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return this.pmsBaseSaleAttrService.list();
    }
}
