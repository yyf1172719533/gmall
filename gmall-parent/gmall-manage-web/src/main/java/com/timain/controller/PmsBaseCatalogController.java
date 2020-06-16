package com.timain.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.timain.pojo.*;
import com.timain.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/16 13:29
 */
@RestController
@CrossOrigin
public class PmsBaseCatalogController {
    
    @Reference
    private PmsBaseCatalog1Service pmsBaseCatalog1Service;
    @Reference
    private PmsBaseCatalog2Service pmsBaseCatalog2Service;
    @Reference
    private PmsBaseCatalog3Service pmsBaseCatalog3Service;
    @Reference
    private PmsBaseAttrValService pmsBaseAttrValService;
    @Reference
    private PmsBaseAttrInfoService pmsBaseAttrInfoService;
    
    @RequestMapping("getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        return this.pmsBaseCatalog1Service.list();
    }
    
    @RequestMapping("getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(Integer catalog1Id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("catalog1_id", catalog1Id);
        return this.pmsBaseCatalog2Service.listByMap(map);
    }

    @RequestMapping("getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(Long catalog2Id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("catalog2_id", catalog2Id);
        return this.pmsBaseCatalog3Service.listByMap(map);
    }
    
    @RequestMapping("getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("attr_id", attrId);
        return this.pmsBaseAttrValService.listByMap(map);
    }
    
    @RequestMapping("attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(Long catalog3Id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("catalog3_id", catalog3Id);
        return this.pmsBaseAttrInfoService.listByMap(map);
    }
}
