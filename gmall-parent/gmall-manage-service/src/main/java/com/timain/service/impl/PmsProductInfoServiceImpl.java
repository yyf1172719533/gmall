package com.timain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.PmsProductImageMapper;
import com.timain.mapper.PmsProductInfoMapper;
import com.timain.mapper.PmsProductSaleAttrMapper;
import com.timain.mapper.PmsProductSaleAttrValMapper;
import com.timain.pojo.PmsProductImage;
import com.timain.pojo.PmsProductInfo;
import com.timain.pojo.PmsProductSaleAttr;
import com.timain.pojo.PmsProductSaleAttrVal;
import com.timain.service.PmsProductInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/17 15:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PmsProductInfoServiceImpl extends ServiceImpl<PmsProductInfoMapper, PmsProductInfo> implements PmsProductInfoService {
    
    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    private PmsProductSaleAttrValMapper pmsProductSaleAttrValMapper;
    
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        //添加商品信息
        this.getBaseMapper().insert(pmsProductInfo);
        //获取商品图片列表并添加图片信息
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            pmsProductImage.setProductId(pmsProductInfo.getId());
            this.pmsProductImageMapper.insert(pmsProductImage);
        }
        //获取商品销售属性列表并添加
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            pmsProductSaleAttr.setProductId(pmsProductInfo.getId());
            this.pmsProductSaleAttrMapper.insert(pmsProductSaleAttr);
            //获取商品销售属性值列表并添加
            List<PmsProductSaleAttrVal> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrVal pmsProductSaleAttrVal : spuSaleAttrValueList) {
                pmsProductSaleAttrVal.setProductId(pmsProductInfo.getId());
                this.pmsProductSaleAttrValMapper.insert(pmsProductSaleAttrVal);
            }
        }
    }
}
