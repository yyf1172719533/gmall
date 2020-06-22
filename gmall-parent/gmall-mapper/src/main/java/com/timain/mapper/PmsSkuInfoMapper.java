package com.timain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.timain.pojo.PmsSkuInfo;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 17:09
 */
public interface PmsSkuInfoMapper extends BaseMapper<PmsSkuInfo> {
    
    List<PmsSkuInfo> findById(Long productId);
}
