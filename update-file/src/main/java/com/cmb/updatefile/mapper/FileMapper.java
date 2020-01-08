package com.cmb.updatefile.mapper;

import com.cmb.updatefile.domain.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * chengyangbing special annotation
 * @Package:      com.cmb.hbx.business
 * @FileName:     FileBusiness.java
 * @ClassName:    FileBusiness     
 * @Description:  文件持久层
 * @Author:       chengyangbing    
 * @CreateDate:   2019/12/23 4:42 PM     
 * @UpdateUser:   chengyangbing     
 * @UpdateDate:   2019/12/23 4:42 PM     
 * @UpdateRemark: 说明本次修改内容    
 * @Version:      v1.0   
 */
@Mapper
public interface FileMapper {

    /**
     * chengyangbing special annotation
     * @param
     * @return v 
     * @throws
     * @Title: 
     * @Description: 新增文件
     */
    int addFile(FileEntity fileEntity);

    /**
     * chengyangbing special annotation
     * @param
     * @return v 
     * @throws
     * @Title: 
     * @Description: 获取文件
     */
    FileEntity getFileByKey(@Param("key") String key);

}
