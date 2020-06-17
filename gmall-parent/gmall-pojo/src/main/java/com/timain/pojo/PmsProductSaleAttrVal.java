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
 * @date 2020/6/17 16:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product_sale_attr_value")
public class PmsProductSaleAttrVal implements Serializable {
    
    private static final long serialVersionUID = -4878284954894764348L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long productId;   //商品ID
    private Long saleAttrId;  //销售属性ID
    private String saleAttrValueName;  //销售属性值名称
}
