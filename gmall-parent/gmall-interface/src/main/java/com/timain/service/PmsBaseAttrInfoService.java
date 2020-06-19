package com.timain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.timain.pojo.PmsBaseAttrInfo;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/16 16:40
 */
public interface PmsBaseAttrInfoService extends IService<PmsBaseAttrInfo> {
    
    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
    
    List<PmsBaseAttrInfo> findAttrInfos(Long catalog3Id);
}
