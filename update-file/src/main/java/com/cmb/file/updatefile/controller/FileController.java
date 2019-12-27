package com.cmb.file.updatefile.controller;


import com.cmb.file.updatefile.business.FileBusiness;
import com.cmb.file.updatefile.domain.entity.FileEntity;
import com.cmb.file.updatefile.domain.view.UploadFileView;
import com.cmb.file.updatefile.util.FastFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;
import java.io.File;
import java.io.FileInputStream;

/**     
 * gaozhao special annotation
 * @Package:      com.cmb.file.updatefile.controller  
 * @FileName:     FileController.java
 * @ClassName:    FileController     
 * @Description:  一句话描述该类的功能  
 * @Author:       gaozhao   
 * @CreateDate:   2019/12/27 10:32     
 * @UpdateUser:   gaozhao     
 * @UpdateDate:   2019/12/27 10:32     
 * @UpdateRemark: 说明本次修改内容    
 * @Version:      v1.0   
 */
@RestController
public class FileController {


    @Autowired
    HttpServletResponse response;

    @Autowired
    FileBusiness fileBusiness;

    /**
     * chengyangbing special annotation
     *
     * @param file 文件
     * @return v
     * @throws
     * @Title:
     * @Description: 上传文件
     */
    @ResponseWrapper
    @PostMapping(value = "/uploadFile")
    public UploadFileView uploadFile(@RequestParam("file") MultipartFile file) {
        //1 文件参数校验
        Assert.notNull(file, "upload file not null");
        //2 文件转换压缩
        File processFile = FastFileUtils.compressFile(FastFileUtils.toFile(file));
        //3 文件业务处理
        FileEntity fileEntity;
        try {
            fileEntity = fileBusiness.addFile(file.getOriginalFilename(), file.getSize(), file.getContentType(), processFile);
        } finally {
            FastFileUtils.deleteFile(processFile);
        }
        //4 返回上传结果
        return new UploadFileView(fileEntity.getKey(), fileEntity.getSize(), fileEntity.getName(), fileEntity.getType(), fileEntity.getAccessUrl());
    }

    /**
     * chengyangbing special annotation
     *
     * @param fileKey 文件Key
     * @return v
     * @throws
     * @Title:
     * @Description: 获取文件
     */
    @RequestMapping(value = "/getFile/{fileKey}")
    public void getFile(@PathVariable("fileKey") String fileKey) {
        //1 查询文件实体
        FileEntity fileEntity = fileBusiness.getFile(fileKey);
        if (fileEntity == null) {
            return;
        }
        //2 Base64反转文件
        File base64File = FastFileUtils.toFile(fileEntity.getValue());
        //3 将文件写出
        try (FileInputStream inputStream = new FileInputStream(base64File)) {
            int readCount;
            byte[] buffer = new byte[4096];
            while ((readCount = inputStream.read(buffer)) > 0) {
                response.getOutputStream().write(buffer, 0, readCount);
            }
            response.getOutputStream().flush();
        } catch (Exception e) {
            throw new IllegalStateException("File write to ResponseStream error", e);
        } finally {
            FastFileUtils.deleteFile(base64File);
        }
    }

}
