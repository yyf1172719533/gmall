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
 * @date 2020/6/19 16:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_sku_attr_value")
public class PmsSkuAttrValue implements Serializable {
    
    private static final long serialVersionUID = -619810931131521142L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;     //编号
    private Long attrId;    //属性ID
    private Long valueId;   //属性值ID
    private Long skuId;     //库存ID
}
