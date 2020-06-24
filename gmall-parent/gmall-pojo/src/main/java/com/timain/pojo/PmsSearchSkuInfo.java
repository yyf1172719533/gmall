package com.timain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/24 16:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PmsSearchSkuInfo implements Serializable {
    
    private static final long serialVersionUID = -7961918595029207774L;
    
    private Long id;
    private String skuName;
    private String skuDesc;
    private Long catalog3Id;
    private Double price;
    private String skuDefaultImg;
    private Double hotScore;
    private Long productId;
    private List<PmsSkuAttrValue> skuAttrValueList; 
}
