package com.timain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.PmsBaseAttrInfoMapper;
import com.timain.pojo.PmsBaseAttrInfo;
import com.timain.service.PmsBaseAttrInfoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/16 16:40
 */
@Service
public class PmsBaseAttrInfoServiceImpl extends ServiceImpl<PmsBaseAttrInfoMapper, PmsBaseAttrInfo> implements PmsBaseAttrInfoService {
}
