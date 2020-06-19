package com.timain.utils;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.timain.config.UploadProperties;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/19 10:56
 */
@Component
@EnableConfigurationProperties(UploadProperties.class)
public class UploadUtils {
    
    private static Log log = LogFactory.getLog(UploadUtils.class);
    
    @Autowired
    private UploadProperties properties;
    @Autowired
    private FastFileStorageClient fileStorageClient;
    
    public String uploadFile(MultipartFile multipartFile) {
        //校验文件类型
        String contentType = multipartFile.getContentType();
        if (!properties.getAllowTypes().contains(contentType)) {
            throw new RuntimeException("文件类型不支持");
        }
        try {
            //获取文件扩展名
            String filename = multipartFile.getOriginalFilename();
            String s = StringUtils.substringAfterLast(filename, ".");
            StorePath storePath = fileStorageClient.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), s, null);
            //返回路径
            return properties.getBaseUrl() + storePath.getFullPath();
        } catch (IOException e) {
            log.error("【文件上传】上传文件失败！....{}", e);
            throw new RuntimeException("【文件上传】上传文件失败！"+e.getMessage());
        }
    }
}
