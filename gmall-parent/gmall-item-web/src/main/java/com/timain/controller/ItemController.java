package com.timain.controller;

import com.timain.pojo.PmsProductSaleAttr;
import com.timain.pojo.PmsSkuInfo;
import com.timain.service.PmsSkuInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/20 15:14
 */
@Controller
public class ItemController {
    
    @Reference
    private PmsSkuInfoService pmsSkuInfoService;
    
    @RequestMapping("{skuId}.html")
    public String item(@PathVariable Long skuId, Model model) {
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoService.findById(skuId);
        List<PmsProductSaleAttr> productSaleAttrList = pmsSkuInfoService.findProSaleAttr(skuId, pmsSkuInfo.getProductId());
        model.addAttribute("spuSaleAttrListCheckBySku", productSaleAttrList);
        model.addAttribute("skuInfo", pmsSkuInfo);
        return "item";
    }
}
