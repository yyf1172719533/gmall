package com.timain.controller;

import com.timain.pojo.PmsProductSaleAttr;
import com.timain.service.PmsProductSaleAttrService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 16:02
 */
@RestController
@CrossOrigin
public class PmsProductSaleAttrController {
    
    @Reference
    private PmsProductSaleAttrService pmsProductSaleAttrService;
    
    @RequestMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(Long productId) {
        return this.pmsProductSaleAttrService.findProductSaleAttrInfo(productId);
    }
    
}
