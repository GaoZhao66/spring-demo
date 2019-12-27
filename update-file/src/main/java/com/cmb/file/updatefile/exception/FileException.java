package com.cmb.file.updatefile.exception;

import lombok.Getter;

/**     
 * chengyangbing special annotation
 * @Package:      com.cmb.hbx.exception
 * @FileName:     FileException.java
 * @ClassName:    FileException     
 * @Description:  文件业务异常
 * @Author:       chengyangbing    
 * @CreateDate:   2019/12/23 5:56 PM     
 * @UpdateUser:   chengyangbing     
 * @UpdateDate:   2019/12/23 5:56 PM     
 * @UpdateRemark: 说明本次修改内容    
 * @Version:      v1.0   
 */
public class FileException extends RuntimeException {

    public FileException() {
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(Throwable cause) {
        super(cause);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public enum Message {
        GET_FILE("获取文件失败!"),
        UPLOAD_FILE("上传文件失败!"),
        ;

        @Getter
        private String value;

        Message(String message) {
            this.value = message;
        }
    }

}
