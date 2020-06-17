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
 * @date 2020/6/17 15:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product_info")
public class PmsProductInfo implements Serializable {
    
    private static final long serialVersionUID = -916365190659221097L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;  //商品ID
    private String productName;  //商品名称
    private String description;  //商品描述
    private Long catalog3Id;   //三级分类ID
    private Long tmId;   //品牌ID
    
    @TableField(exist = false)
    private List<PmsProductImage> pmsProductImages;
    @TableField(exist = false)
    private List<PmsProductSaleAttr> pmsProductSaleAttrs;
}
