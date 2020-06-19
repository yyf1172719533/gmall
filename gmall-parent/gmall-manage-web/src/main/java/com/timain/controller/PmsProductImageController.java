package com.timain.controller;

import com.timain.pojo.PmsProductImage;
import com.timain.service.PmsProductImageService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 16:19
 */
@RestController
@CrossOrigin
public class PmsProductImageController {
    
    @Reference
    private PmsProductImageService pmsProductImageService;
    
    @RequestMapping("spuImageList")
    public List<PmsProductImage> spuImageList(Long productId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("product_id", productId);
        return this.pmsProductImageService.listByMap(map);
    }
}
