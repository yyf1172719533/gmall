package com.timain.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.*;
import com.timain.pojo.*;
import com.timain.service.PmsSkuInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import org.springframework.transaction.annotation.Transactional;


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
    @Autowired
    private JedisPool jedisPool;
    
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
        Jedis jedis = jedisPool.getResource();
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        String skuKey = "sku:" + skuId + ":info";
        String skuJson = jedis.get(skuKey);
        if (StringUtils.isNotBlank(skuJson)) {
            pmsSkuInfo = JSON.parseObject(skuJson, PmsSkuInfo.class);
        } else {
            //设置分布式锁
            /*jedis.set("sku:" + skuId + ":lock", "1", "nx", "px", 10);*/
            pmsSkuInfo = getSkuInfos(skuId);
            if (null!=pmsSkuInfo) {
                jedis.set(skuKey, JSON.toJSONString(pmsSkuInfo));
            } else {
                //为了缓存穿透，将null值或空字符串设置给redis
                jedis.setex(skuKey, 60*3, JSON.toJSONString(""));
            }
            
        }
        return pmsSkuInfo;
    }
    
    private PmsSkuInfo getSkuInfos(Long skuId) {
        PmsSkuInfo pmsSkuInfo = this.getBaseMapper().selectById(skuId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sku_id", skuId);
        List<PmsSkuImage> pmsSkuImages = this.pmsSkuImageMapper.selectByMap(map);
        pmsSkuInfo.setSkuImageList(pmsSkuImages);
        return pmsSkuInfo;
    }

    /**
     * 获取销售属性以及销售属性值并且判断属性值是否选中
     * @param skuId
     * @param productId
     * @return
     */
    public List<PmsProductSaleAttr> findProSaleAttr(Long skuId, Long productId) {
        return this.pmsProductSaleAttrMapper.selectAllById(skuId, productId);
    }

    public Map<String, Object> findSkuInfoById(Long productId) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<PmsSkuInfo> pmsSkuInfoList = this.getBaseMapper().findById(productId);
        for (PmsSkuInfo pmsSkuInfo : pmsSkuInfoList) {
            String v = String.valueOf(pmsSkuInfo.getId());
            String k = "";
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                k += String.valueOf(pmsSkuSaleAttrValue.getSaleAttrValueId()) + "|";
            }
            map.put(k, v);
        }
        return map;
    }
}
