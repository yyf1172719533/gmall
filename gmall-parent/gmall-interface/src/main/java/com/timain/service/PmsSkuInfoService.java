package com.timain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.timain.pojo.PmsSkuInfo;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 17:20
 */
public interface PmsSkuInfoService extends IService<PmsSkuInfo> {
    
    void insertSkuInfo(PmsSkuInfo pmsSkuInfo);
}
