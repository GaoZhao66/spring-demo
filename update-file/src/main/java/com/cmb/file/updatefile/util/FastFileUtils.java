package com.cmb.file.updatefile.util;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * chengyangbing special annotation
 *
 * @Package: com.cmb.hbx.common.util
 * @FileName: FastFileUtils.java
 * @ClassName: FastFileUtils
 * @Description: 快速操作文件工具类
 * @Author: chengyangbing
 * @CreateDate: 2019/12/23 2:45 PM
 * @UpdateUser: chengyangbing
 * @UpdateDate: 2019/12/23 2:45 PM
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public abstract class FastFileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FastFileUtils.class);

    private static final String ROOT_PATH = System.getProperty("user.dir");

    private static final String BASE64_FILE = ROOT_PATH + File.separator + "BASE64-FILE-%s";

    private static final String COMPRESS_FILE = ROOT_PATH + File.separator + "COMPRESS-FILE-%s";

    /**
     * chengyangbing special annotation
     *
     * @param
     * @return v
     * @throws
     * @Title:
     * @Description: 获取后缀
     */
    public static String getSuffix(File file) {
        if (file == null) {
            return null;
        }
        return file.getName()
                .substring(file.getName().lastIndexOf(".") + 1);
    }

    /**
     * chengyangbing special annotation
     *
     * @param
     * @return v
     * @throws
     * @Title:
     * @Description: 清理文件
     */
    public static void deleteFile(File tempFile) {
        if (tempFile != null && tempFile.exists()) {
            logger.info("Temp file: {} is cleaned", tempFile.getName());
            tempFile.delete();
        } else {
            logger.info("Temp file: {} does not exist", tempFile.getName());
        }
    }

    /**
     * chengyangbing special annotation
     *
     * @param
     * @return v
     * @throws
     * @Title:
     * @Description: 转换文件
     */
    public static File toFile(String base64Data) {
        if (StringUtils.isBlank(base64Data)) {
            return null;
        }
        //1 生成临时文件
        File tempFile = new File(String.format(BASE64_FILE, UUIDUtils.generator())
        );
        //2 将Base64写入文件
        try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] bytes = new BASE64Decoder().decodeBuffer(base64Data);
            outputStream.write(bytes);
        } catch (Exception e) {
            deleteFile(tempFile);
            throw new IllegalStateException("Base64Data to file error", e);
        }

        return tempFile;
    }

    /**
     * chengyangbing special annotation
     *
     * @param
     * @return v
     * @throws
     * @Title:
     * @Description: 转换文件
     */
    public static File toFile(MultipartFile sourceFile) {
        if (sourceFile == null) {
            return null;
        }
        //1 生成临时文件
        File tempFile = new File(
                String.format(sourceFile.getOriginalFilename()));
        //2 将MultipartFile写入临时文件
        try {
            FileUtils.copyInputStreamToFile(sourceFile.getInputStream(), tempFile);
        } catch (Exception e) {
            deleteFile(tempFile);
            throw new IllegalStateException("MultipartFile to file error", e);
        }
        return tempFile;
    }

    /**
     * chengyangbing special annotation
     *
     * @param
     * @return v
     * @throws
     * @Title:
     * @Description: 将File文件转为Base64图片字符
     */
    public static String toBase64(File sourceFile) {
        String fileBase64;
        //1 判断文件是否存在
        if (sourceFile == null) {
            return null;
        }
        //2 将文件转换为Base64
        try (InputStream inputStream = new FileInputStream(sourceFile)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            fileBase64 = new BASE64Encoder().encode(bytes);
        } catch (Exception e) {
            deleteFile(sourceFile);
            throw new IllegalStateException("File to base64 error", e);
        }
        fileBase64 = fileBase64.replaceAll("[\\s*\t\n\r]", "");
        return fileBase64 != null ? fileBase64 : null;
    }

    /**
     * chengyangbing special annotation
     *
     * @param
     * @return v
     * @throws
     * @Title:
     * @Description: 压缩文件
     */
    public static File compressFile(File sourceFile) {
        //1 校验源文件
        if (sourceFile == null) {
            return null;
        }
        //2 开始压缩文件
        String compressFilePath = String.format(COMPRESS_FILE, UUIDUtils.generator() + "." + getSuffix(sourceFile));
        try {
            Thumbnails.of(sourceFile).scale(1f).outputQuality(0.5f).toFile(compressFilePath);
        } catch (Exception e) {
            deleteFile(sourceFile);
            throw new IllegalStateException("Compress file error", e);
        }
        //3 清理源文件并返回
        deleteFile(sourceFile);
        return new File(compressFilePath);
    }

}
