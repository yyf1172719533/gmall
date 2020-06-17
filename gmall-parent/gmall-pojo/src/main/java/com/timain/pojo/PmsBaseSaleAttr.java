package com.timain.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/17 18:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_base_sale_attr")
public class PmsBaseSaleAttr implements Serializable {
    
    private static final long serialVersionUID = -4036971254161358786L;
    
    private Long id;   //编号
    private String name;  //销售属性名称
}
