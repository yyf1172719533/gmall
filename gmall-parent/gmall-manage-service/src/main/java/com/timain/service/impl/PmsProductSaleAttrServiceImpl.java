package com.timain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.PmsProductSaleAttrMapper;
import com.timain.mapper.PmsProductSaleAttrValMapper;
import com.timain.pojo.PmsProductSaleAttr;
import com.timain.pojo.PmsProductSaleAttrVal;
import com.timain.service.PmsProductSaleAttrService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/17 16:59
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PmsProductSaleAttrServiceImpl extends ServiceImpl<PmsProductSaleAttrMapper, PmsProductSaleAttr> implements PmsProductSaleAttrService {

    @Autowired
    private PmsProductSaleAttrValMapper pmsProductSaleAttrValMapper;
    
    public List<PmsProductSaleAttr> findProductSaleAttrInfo(Long productId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("product_id", productId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = this.getBaseMapper().selectByMap(map);
        for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrs) {
            map.put("sale_attr_id", pmsProductSaleAttr.getSaleAttrId());
            List<PmsProductSaleAttrVal> pmsProductSaleAttrVals = this.pmsProductSaleAttrValMapper.selectByMap(map);
            pmsProductSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrVals);
        }
        return pmsProductSaleAttrs;
    }
}
