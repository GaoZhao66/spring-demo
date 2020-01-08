package com.cmb.updatefile.constant;

/**     
 * gaozhao special annotation
 * @Package:      com.cmb.mkw.common.constants
 * @FileName:     BaseConstant.java
 * @ClassName:    BaseConstant     
 * @Description:  基础产量定义
 * @Author:       gaozhao
 * @CreateDate:   2019-09-17 15:59     
 * @UpdateUser:   gaozhao
 * @UpdateDate:   2019-09-17 15:59     
 * @UpdateRemark: 说明本次修改内容    
 * @Version:      v1.0   
 */
public interface Constant {

    /**
     * Y：启用
     */
    String IS_ENABLE_Y = "Y";

    /**
     * Y：启用
     */
    String IS_ENABLE_VALUE_Y = "启用";

    /**
     * N：停用
     */
    String IS_ENABLE_N = "N";

    /**
     * N：停用
     */
    String IS_ENABLE_VALUE_N = "停用";

    /**
     * 是否逻辑删除-否
     */
    String IS_DELETE_N = "N";

    /**
     * 是否逻辑删除-是
     */
    String IS_DELETE_Y = "Y";

    /**
     * Y 字符串
     */
    String Y = "Y";

    /**
     * N 字符串
     */
    String N = "N";

    /**
     * 临时文件夹
     */
    String TEMP_PATH = "./temp/";

    /**
     * 支持的图片格式
     */
    String SUPPORT_IMAGE_FORMAT = ".JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.PNG|.png";

    /**
     * 上传图片格式正则表达式
     */
    String IMAGE_FORMAT = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.PNG|.png)$";

    /**
     * 获取所有活动下拉列表项缓存KEY
     */
    String CACHE_ACTIVITY_OPS_KEY = "ACTIVITY_OPS_KEY";

    /**
     * 默认LOGO
     * */
    String CMBLOGO  = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADYAAAA2CAYAAACMRWrdAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDY3IDc5LjE1Nzc0NywgMjAxNS8wMy8zMC0yMzo0MDo0MiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkIyOUY2NUNDRUIzNDExRTk4NEY2ODk1MjFFMkMxQkM2IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkIyOUY2NUNERUIzNDExRTk4NEY2ODk1MjFFMkMxQkM2Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QjI5RjY1Q0FFQjM0MTFFOTg0RjY4OTUyMUUyQzFCQzYiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QjI5RjY1Q0JFQjM0MTFFOTg0RjY4OTUyMUUyQzFCQzYiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6PQ+p4AAADLElEQVR42uya/UtTURjHv9MRmo7SorJ+rKgkCPoDohdJBgZFIBH9EkW/B0FgGTUzbWpYRFBkprRZrlDIQiULsUR7EUtSezFf0E3DNvNKyzld53SMXE53dr2De9b9woVx99zD+ew55znP89zpnE6nEUARuZIQGXKQ64iOgNkNBkOSXq+PCCqv1wtJkhxR1FORAkU1zZIUhQiVBqaBaWB8GvcAU1MygohagWrqgObXgH0QWERmuW4tkLIDSN4gKJjbDVwoALq6/e8PO4GmV8DBdCAtVcClmHNpNtRMWcuBlreCgTU2A5+/BLe7fgvw+QQCe9bAZyeNAR0fBQGjHhiw89t39wjkMZK/cmtyUhAwnQ5Ylshvv3KFQB7buoXfdnOyQGDG3UB0dHC7vWlA3GKBwOLjgJPHg3hqE5C+j2Npkwral5CQoKpDmp5ldx8A7Z1/71EP7doOHNgf/HmXyyUfzEIygNQUYHli+ABp+O/rB2JigI3rgdhYvucoWMi5Ij1vsvPIr/kBaH0H5J7j2xdytGY1u8JetvwcB05nMajfv6gDMF0UvB4b+Q5kEO909/rf/9RFEtcCQcGGvgKnTMDgUODv29qBwmuCgfX0MSjXyPx2L9+QrLtYELBOkkFnkj31w803WP1zoLRMmYm97wgTGC3maGCYDLHfUP0EsFUsbFLmQhJ581l7QFGwF01A/hX5g1ZUAY9q5D2bSyro1jb2ucQKPK6VN07Ac6zYsvClRA9weqDu3MZnPzEBnM9jUXam7txjJcoeowIeM8Qrs09ulrByP5jGSEWcYZoN9Udl98kqeKgAWJSCqfHVGyxDmUvD3xhUsOrZVgmUVygQPJSU+TKLsP+q386gKByPKsnetdpUBEaVZQZ6+/wzeJqe0WUYiqqqgdsWFYHR5PlsDgOhnjqTDXg88saqfQoUlcqIiuES7cOfyGTd3oWqrp7FgsOHVFJBj46y0K6EGhoFaQ2EqvnqY+39mAamgWlgGtj/CzZX00Ztmm+eAVMqWtTRdpvatXRJiGA8/XFtj2lgGpgG5vCG8rpe5ZpmGaRR8agkSfTPzqsihG2AXMd+CTAAlQMCf8IM4jEAAAAASUVORK5CYII=";

}
