package com.cmb.file.updatefile.domain.entity;

import lombok.Data;

/**
 * chengyangbing special annotation
 *
 * @Package: com.cmb.hbx.domain.entity
 * @FileName: FileEntity.java
 * @ClassName: FileEntity
 * @Description: 文件实体
 * @Author: chengyangbing
 * @CreateDate: 2019/12/23 4:40 PM
 * @UpdateUser: chengyangbing
 * @UpdateDate: 2019/12/23 4:40 PM
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Data
public class FileEntity extends BaseEntity{

    /**
     * @Desc: 文件键
     */
    private String key;

    /**
     * @Desc: 文件内容
     */
    private String value;

    /**
     * @Desc: 文件大小
     */
    private Long size;

    /**
     * @Desc: 文件名称
     */
    private String name;

    /**
     * @Desc: 文件类型
     */
    private String type;

    /**
     * @Desc: 访问路径
     */
    private String accessUrl;

    public FileEntity() {
    }

    public FileEntity(String key, String value, Long size, String name, String type, String accessUrl) {
        this.key = key;
        this.value = value;
        this.size = size;
        this.name = name;
        this.type = type;
        this.accessUrl = accessUrl;
    }
}
