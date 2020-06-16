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
 * @date 2020/6/16 11:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_base_catalog1")
public class PmsBaseCatalog1 implements Serializable {
    
    private static final long serialVersionUID = -7898164380987044898L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;  //编号
    private String name; //分类名称
    
    @TableField(exist = false)
    private List<PmsBaseCatalog2> catalog2List;
}
