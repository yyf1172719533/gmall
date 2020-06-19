package com.timain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.timain.pojo.PmsProductSaleAttr;

import java.util.List;


/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/17 16:58
 */
public interface PmsProductSaleAttrService extends IService<PmsProductSaleAttr> {
    
    List<PmsProductSaleAttr> findProductSaleAttrInfo(Long productId);
    
}
