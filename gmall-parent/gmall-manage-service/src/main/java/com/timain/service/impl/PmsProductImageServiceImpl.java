package com.timain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.PmsProductImageMapper;
import com.timain.pojo.PmsProductImage;
import com.timain.service.PmsProductImageService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 16:22
 */
@Service
public class PmsProductImageServiceImpl extends ServiceImpl<PmsProductImageMapper, PmsProductImage> implements PmsProductImageService {
}
