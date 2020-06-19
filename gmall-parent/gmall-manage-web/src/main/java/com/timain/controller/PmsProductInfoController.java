package com.timain.controller;

import com.timain.pojo.PmsBaseSaleAttr;
import com.timain.pojo.PmsProductInfo;
import com.timain.service.PmsBaseSaleAttrService;
import com.timain.service.PmsProductInfoService;
import com.timain.utils.UploadUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/17 15:18
 */
@RestController
@CrossOrigin
public class PmsProductInfoController {
    
    @Reference
    private PmsProductInfoService pmsProductInfoService;
    @Reference
    private PmsBaseSaleAttrService pmsBaseSaleAttrService;
    @Autowired
    private UploadUtils uploadUtils;
    
    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(Long catalog3Id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("catalog3_id", catalog3Id);
        return pmsProductInfoService.listByMap(map);
    }
    
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return this.pmsBaseSaleAttrService.list();
    }
    
    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        return uploadUtils.uploadFile(multipartFile);
    }
    
    @RequestMapping("saveSpuInfo")
    public void saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        this.pmsProductInfoService.saveSpuInfo(pmsProductInfo);
    }
}
