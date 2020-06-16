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
 * @date 2020/6/16 11:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_base_catalog3")
public class PmsBaseCatalog3 implements Serializable {
    
    private static final long serialVersionUID = -7278273100624903943L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Long catalog2Id;
}
