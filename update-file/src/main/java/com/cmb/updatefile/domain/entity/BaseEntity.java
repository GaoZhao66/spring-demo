package com.cmb.updatefile.domain.entity;

import com.cmb.updatefile.constant.Constant;
import com.cmb.updatefile.util.DateUtils;
import com.cmb.updatefile.util.UUIDUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * chengyangbing special annotation
 * @Package:      com.cmb.mkw.common.domain
 * @FileName:     BaseEntity.java
 * @ClassName:    BaseEntity
 * @Description:  基础 Entity 类
 * @Author:       chengyangbing
 * @CreateDate:   2019/10/14 11:23 PM
 * @UpdateUser:   chengyangbing
 * @UpdateDate:   2019/10/14 11:23 PM
 * @UpdateRemark: 说明本次修改内容
 * @Version:      v1.0
 */
@Data
public abstract class BaseEntity implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据主键
     */
    private Integer id;

    /**
     * 业务主键
     */
    private String tuid;

    /**
     * 关键字
     */
    private String keyWord;

    /**
     * 创建人ID
     **/
    private String creatorId;

    /**
     * 创建人姓名
     **/
    private String creatorName;

    /**
     * 创建时间
     **/
    private Date creatorDate;

    /**
     * 修改人ID
     **/
    private String modifyId;

    /**
     * 修改人姓名
     **/
    private String modifyName;

    /**
     * 修改时间
     **/
    private Date modifyDate;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 启用状态（Y：启用 N：停用）
     **/
    private String isEnable;

    /**
     * 删除状态（Y：已删除 N：未删除）
     */
    private String isDelete;

    public BaseEntity() {}

    public void creatorData() {
        this.tuid = UUIDUtils.generator();
        this.isEnable = Constant.IS_ENABLE_Y;
        this.creatorDate = DateUtils.getCurrentDate();
        this.modifyDate = DateUtils.getCurrentDate();
        this.version = System.currentTimeMillis();
        this.isDelete = Constant.IS_DELETE_N;
    }

    public void modifyData() {
        this.modifyDate = DateUtils.getCurrentDate();
        this.version = System.currentTimeMillis();
    }

    /**
     * @Description: 设置启用状态的反值
     */
    public void setAgainstEnable() {
        this.modifyData();
        this.isEnable = Constant.IS_ENABLE_Y.equalsIgnoreCase(this.isEnable) ? Constant.IS_ENABLE_N : Constant.IS_ENABLE_Y;
    }

    /**
     * @Description: 设置删除状态的反值
     */
    public void setAgainstDelete() {
        this.modifyData();
        this.isDelete = Constant.IS_DELETE_Y.equalsIgnoreCase(this.isDelete) ? Constant.IS_DELETE_N : Constant.IS_DELETE_Y;
    }


}
