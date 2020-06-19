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
 * @date 2020/6/19 16:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_sku_image")
public class PmsSkuImage implements Serializable {
    
    private static final long serialVersionUID = 2052205645340829151L;
    
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;     //编号
    private Long skuId;  //库存ID
    private String imgName;   //图片名称
    private String imgUrl;    //图片路径
    private Long productImgId;    //商品图片ID
    private String isDefault;    //是否默认  1-是 0-否
}
