package com.timain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timain.mapper.PmsBaseAttrInfoMapper;
import com.timain.mapper.PmsBaseAttrValMapper;
import com.timain.pojo.PmsBaseAttrInfo;
import com.timain.pojo.PmsBaseAttrValue;
import com.timain.service.PmsBaseAttrInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/16 16:40
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PmsBaseAttrInfoServiceImpl extends ServiceImpl<PmsBaseAttrInfoMapper, PmsBaseAttrInfo> implements PmsBaseAttrInfoService {
    
    @Autowired
    private PmsBaseAttrValMapper pmsBaseAttrValMapper;
    
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        if (pmsBaseAttrInfo.getId()==null) {
            this.baseMapper.insert(pmsBaseAttrInfo);
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValMapper.insert(pmsBaseAttrValue);
            }
        } else {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("attr_id", pmsBaseAttrInfo.getId());
            this.pmsBaseAttrValMapper.deleteByMap(map);
            for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrInfo.getAttrValueList()) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValMapper.insert(pmsBaseAttrValue);
            }
        }
    }

    public List<PmsBaseAttrInfo> findAttrInfos(Long catalog3Id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("catalog3_id", catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = this.getBaseMapper().selectByMap(map);
        map.clear();
        for (PmsBaseAttrInfo pmsBaseAttrInfo : pmsBaseAttrInfos) {
            map.put("attr_id", pmsBaseAttrInfo.getId());
            List<PmsBaseAttrValue> pmsBaseAttrValues = this.pmsBaseAttrValMapper.selectByMap(map);
            pmsBaseAttrInfo.setAttrValueList(pmsBaseAttrValues);
        }
        return pmsBaseAttrInfos;
    }
}
