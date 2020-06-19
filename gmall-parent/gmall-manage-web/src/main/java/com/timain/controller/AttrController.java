package com.timain.controller;

import com.timain.pojo.PmsBaseAttrInfo;
import com.timain.pojo.PmsBaseAttrValue;
import com.timain.service.PmsBaseAttrInfoService;
import com.timain.service.PmsBaseAttrValService;
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
 * @date 2020/6/17 9:31
 */
@RestController
@CrossOrigin
public class AttrController {

    @Reference
    private PmsBaseAttrValService pmsBaseAttrValService;
    @Reference
    private PmsBaseAttrInfoService pmsBaseAttrInfoService;


    @RequestMapping("getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("attr_id", attrId);
        return this.pmsBaseAttrValService.listByMap(map);
    }

    @RequestMapping("attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(Long catalog3Id) {
        return this.pmsBaseAttrInfoService.findAttrInfos(catalog3Id);
    }
    
    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        this.pmsBaseAttrInfoService.saveAttrInfo(pmsBaseAttrInfo);
    }
    
    @RequestMapping("deleteAttrValueById")
    public void deleteAttrValueById(Long id) {
        this.pmsBaseAttrValService.removeById(id);
    }
}
