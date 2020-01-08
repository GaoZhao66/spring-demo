package com.cmb.updatefile.domain.view;

import com.cmb.updatefile.domain.entity.BaseView;
import lombok.Data;

/**
 * chengyangbing special annotation
 * @Package:      com.cmb.hbx.domain.view
 * @FileName:     UploadFileView.java
 * @ClassName:    UploadFileView     
 * @Description:  上传文件结果
 * @Author:       chengyangbing    
 * @CreateDate:   2019/12/23 5:03 PM     
 * @UpdateUser:   chengyangbing     
 * @UpdateDate:   2019/12/23 5:03 PM     
 * @UpdateRemark: 说明本次修改内容    
 * @Version:      v1.0   
 */
@Data
public class UploadFileView extends BaseView {

    /**
     * @Desc: 文件键
     */
    private String key;

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

    public UploadFileView(){}

    public UploadFileView(String key, Long size, String name, String type, String accessUrl) {
        this.key = key;
        this.size = size;
        this.name = name;
        this.type = type;
        this.accessUrl = accessUrl;
    }

}
