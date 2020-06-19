package com.timain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 10:54
 */
@Data
@ConfigurationProperties(prefix = "upload")
public class UploadProperties {
    
    private String baseUrl;
    
    private List<String> allowTypes;
}
