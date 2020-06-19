package com.timain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 16:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_sku_info")
public class PmsSkuInfo implements Serializable {
    
    private static final long serialVersionUID = -5916981278446852462L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;    //库存ID
    private Long productId;   //商品ID
    private Double price;    //价格
    private String skuName;   //sku名称
    private String skuDesc;   //商品规格描述
    private Double weight;    //商品重量
    private Long tmId;     //品牌
    private Long catalog3Id;    //三级分类ID
    private String skuDefaultImg;    //默认显示图片
    
    @TableField(exist = false)
    private List<PmsSkuImage> skuImageList;
    @TableField(exist = false)
    private List<PmsSkuAttrValue> skuAttrValueList;
    @TableField(exist = false)
    private List<PmsSkuSaleAttrValue> skuSaleAttrValueList;
}
