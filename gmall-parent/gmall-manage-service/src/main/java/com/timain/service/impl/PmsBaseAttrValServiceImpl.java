package com.timain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.PmsBaseAttrValMapper;
import com.timain.pojo.PmsBaseAttrValue;
import com.timain.service.PmsBaseAttrValService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/16 15:33
 */
@Service
public class PmsBaseAttrValServiceImpl extends ServiceImpl<PmsBaseAttrValMapper, PmsBaseAttrValue> implements PmsBaseAttrValService {
}
