package com.timain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.PmsSkuAttrValueMapper;
import com.timain.mapper.PmsSkuImageMapper;
import com.timain.mapper.PmsSkuInfoMapper;
import com.timain.mapper.PmsSkuSaleAttrValueMapper;
import com.timain.pojo.PmsSkuAttrValue;
import com.timain.pojo.PmsSkuImage;
import com.timain.pojo.PmsSkuInfo;
import com.timain.pojo.PmsSkuSaleAttrValue;
import com.timain.service.PmsSkuInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
