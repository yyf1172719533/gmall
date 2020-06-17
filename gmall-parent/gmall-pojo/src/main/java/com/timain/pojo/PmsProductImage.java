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
 * @date 2020/6/17 16:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product_image")
public class PmsProductImage implements Serializable {
    
    private static final long serialVersionUID = -8699641980219813867L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;   //编号
    private Long productId;   //商品ID
    private String imgName;   //图片名称
    private String imgUrl;    //图片路径
}
