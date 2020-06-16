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
 * @date 2020/6/16 16:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_base_attr_info")
public class PmsBaseAttrInfo implements Serializable {
    
    private static final long serialVersionUID = 7627517711373515707L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;  //编号
    private String attrName;  //属性名称
    private Long catalog3Id;
    private String isEnabled; //启用-1  停用-0
}
