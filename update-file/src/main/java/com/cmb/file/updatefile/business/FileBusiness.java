package com.cmb.file.updatefile.business;

import com.cmb.file.updatefile.domain.entity.FileEntity;

import java.io.File;

/**
 * chengyangbing special annotation
 *
 * @Package:        com.cmb.hbx.business
 * @FileName:       FileBusiness.java
 * @ClassName:      FileBusiness
 * @Description:    文件业务层
 * @Author:         chengyangbing
 * @CreateDate:     2019/12/23 6:29 PM
 * @UpdateUser:     chengyangbing
 * @UpdateDate:     2019/12/23 6:29 PM
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public interface FileBusiness {

    /**
     * chengyangbing special annotation
     *
     * @param fileKey 文件键值
     * @return v
     * @throws
     * @Title:
     * @Description: 获取文件
     */
    FileEntity getFile(String fileKey);

    /**
     * chengyangbing special annotation
     *F
     * @param name 文件名称
     * @param size 文件大小
     * @param type 文件类型
     * @param file 文件数据
     * @return v
     * @throws
     * @Title:
     * @Description: 保存文件
     */
    FileEntity addFile(String name, long size, String type, File file);

}
