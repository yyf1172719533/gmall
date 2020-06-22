package com.timain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.timain.pojo.PmsProductSaleAttr;
import com.timain.pojo.PmsSkuInfo;

import java.util.List;
import java.util.Map;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 17:20
 */
public interface PmsSkuInfoService extends IService<PmsSkuInfo> {
    
    void insertSkuInfo(PmsSkuInfo pmsSkuInfo);
    
    PmsSkuInfo findById(Long skuId);
    
    List<PmsProductSaleAttr> findProSaleAttr(Long skuId, Long productId);
    
    Map<String, Object> findSkuInfoById(Long productId);
}
