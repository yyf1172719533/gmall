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
 * @date 2020/6/16 15:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_base_attr_value")
public class PmsBaseAttrValue implements Serializable {
    
    private static final long serialVersionUID = -138815624350372262L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;  //编号
    private String valueName;  //属性值名称
    private Long attrId;  //属性ID
    private String isEnabled;  //启用-1  停用-0
}
