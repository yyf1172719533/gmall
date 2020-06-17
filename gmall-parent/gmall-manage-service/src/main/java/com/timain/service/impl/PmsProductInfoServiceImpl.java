package com.timain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.PmsProductInfoMapper;
import com.timain.pojo.PmsProductInfo;
import com.timain.service.PmsProductInfoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/17 15:17
 */
@Service
public class PmsProductInfoServiceImpl extends ServiceImpl<PmsProductInfoMapper, PmsProductInfo> implements PmsProductInfoService {
}
