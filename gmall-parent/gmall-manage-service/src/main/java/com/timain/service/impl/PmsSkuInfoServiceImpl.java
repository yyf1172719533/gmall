package com.timain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.*;
import com.timain.pojo.*;
import com.timain.service.PmsSkuInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 17:21
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PmsSkuInfoServiceImpl extends ServiceImpl<PmsSkuInfoMapper, PmsSkuInfo> implements PmsSkuInfoService {
    
    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;
    @Autowired
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;
    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    private PmsProductSaleAttrValMapper pmsProductSaleAttrValMapper;
    
    public void insertSkuInfo(PmsSkuInfo pmsSkuInfo) {
        //添加库存信息
        this.getBaseMapper().insert(pmsSkuInfo);
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(pmsSkuInfo.getId());
            this.pmsSkuImageMapper.insert(pmsSkuImage);
        }
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(pmsSkuInfo.getId());
            this.pmsSkuAttrValueMapper.insert(pmsSkuAttrValue);
        }
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(pmsSkuInfo.getId());
            this.pmsSkuSaleAttrValueMapper.insert(pmsSkuSaleAttrValue);
        }
    }

    public PmsSkuInfo findById(Long skuId) {
        PmsSkuInfo pmsSkuInfo = this.getBaseMapper().selectById(skuId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sku_id", skuId);
        List<PmsSkuImage> pmsSkuImages = this.pmsSkuImageMapper.selectByMap(map);
        pmsSkuInfo.setSkuImageList(pmsSkuImages);
        return pmsSkuInfo;
    }

    /**
     * 获取销售属性以及销售属性值并且判断属性值是否选中
     * 代码太烂，后期需修改
     * @param skuId
     * @param productId
     * @return
     */
    public List<PmsProductSaleAttr> findProSaleAttr(Long skuId, Long productId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("product_id", productId);
        List<PmsProductSaleAttr> productSaleAttrList = this.pmsProductSaleAttrMapper.selectByMap(map);
        List<PmsProductSaleAttrVal> pmsProductSaleAttrValList = null;
        for (PmsProductSaleAttr pmsProductSaleAttr : productSaleAttrList) {
            map.put("sale_attr_id", pmsProductSaleAttr.getSaleAttrId());
            pmsProductSaleAttrValList = this.pmsProductSaleAttrValMapper.selectByMap(map);
            pmsProductSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValList);
            map.remove("product_id");
            map.put("sku_id", skuId);
            for (PmsProductSaleAttrVal pmsProductSaleAttrVal : pmsProductSaleAttrValList) {
                map.put("sale_attr_value_id", pmsProductSaleAttrVal.getId());
                List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList = pmsSkuSaleAttrValueMapper.selectByMap(map);
                if (!pmsSkuSaleAttrValueList.isEmpty()) {
                    pmsProductSaleAttrVal.setIsChecked(true);
                } else {
                    pmsProductSaleAttrVal.setIsChecked(false);
                }
            }
            map.clear();
            map.put("product_id", productId);
        }
        return productSaleAttrList;
    }
}
