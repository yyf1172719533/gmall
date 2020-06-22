package com.timain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.timain.pojo.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/17 16:58
 */
public interface PmsProductSaleAttrMapper extends BaseMapper<PmsProductSaleAttr> {
    
    List<PmsProductSaleAttr> selectAllById(@Param("skuId") Long skuId, @Param("productId") Long productId);
}
