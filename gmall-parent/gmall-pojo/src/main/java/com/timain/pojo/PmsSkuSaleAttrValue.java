package com.timain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 16:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_sku_sale_attr_value")
public class PmsSkuSaleAttrValue implements Serializable {
    
    private static final long serialVersionUID = 7903764489565888340L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;       //编号
    private Long skuId;     //库存ID
    private Long saleAttrId;   //销售属性ID
    private Long saleAttrValueId;   //销售属性值ID
    private String saleAttrName;    //销售属性名称
    private String saleAttrValueName;    //销售属性值名称
}
