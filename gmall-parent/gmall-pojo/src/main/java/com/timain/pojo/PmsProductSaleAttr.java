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
 * @date 2020/6/17 16:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product_sale_attr")
public class PmsProductSaleAttr implements Serializable {
    
    private static final long serialVersionUID = -2059647408103136515L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;  
    private Long productId;  //商品ID
    private Long saleAttrId;  //销售属性ID
    private String saleAttrName;   //销售属性名称
    
    @TableField(exist = false)
    private List<PmsProductSaleAttrVal> pmsProductSaleAttrVals;
}
