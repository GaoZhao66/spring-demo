package com.cmb.updatefile.business.impl;

import com.cmb.updatefile.business.FileBusiness;
import com.cmb.updatefile.domain.entity.FileEntity;
import com.cmb.updatefile.exception.FileException;
import com.cmb.updatefile.mapper.FileMapper;
import com.cmb.updatefile.util.FastFileUtils;
import com.cmb.updatefile.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * gaozhao special annotation
 *
 * @Package: com.cmb.hbx.business.impl
 * @FileName: FileBusinessImpl.java
 * @ClassName: FileBusinessImpl
 * @Description: 文件业务层实现
 * @Author: gaozhao
 * @CreateDate: 2019/12/23 6:41 PM
 * @UpdateUser: gaozhao
 * @UpdateDate: 2019/12/23 6:41 PM
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Service
public class FileBusinessImpl implements FileBusiness {

    @Value(value = "${file.base-url}")
    String fileAccessUrl;

    @Autowired
    private FileMapper fileMapper;

    @Override
    public FileEntity getFile(String key) {
        FileEntity fileEntity;
        try {
            fileEntity = fileMapper.getFileByKey(key);
        } catch (Exception e) {
            throw new FileException(FileException.Message.GET_FILE.getValue(), e);
        }
        return fileEntity;
    }

    @Override
    public FileEntity addFile(String name, long size, String type, File file) {
        FileEntity fileEntity;
        try {
            String fileKey = UUIDUtils.generator();
            String fileValue = FastFileUtils.toBase64(file);
            fileEntity = new FileEntity(fileKey, fileValue, size, name, type, (fileAccessUrl + fileKey));
            fileEntity.creatorData();
            fileMapper.addFile(fileEntity);
        } catch (Exception e) {
            throw new FileException(FileException.Message.UPLOAD_FILE.getValue(), e);
        }
        return fileEntity;
    }
}
