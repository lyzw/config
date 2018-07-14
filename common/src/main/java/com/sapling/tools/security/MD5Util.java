package com.sapling.tools.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import com.sapling.tools.common.ByteUtil;
import com.sapling.tools.io.NormalIOUtil;

import java.io.*;

/**
 * MD5工具类
 *
 * @author zhouwei
 * @version v1.0
 * @createdate 2017/5/18.
 * @since v1.0
 */
public class MD5Util {

    /**
     * MD5加密字符串
     *
     * @param content 字符串内容
     * @param charset 编码集
     * @return 加密后的字符串
     * @throws UnsupportedEncodingException 不支持的字符集
     * @throws NoSuchAlgorithmException     不支持的加密类型
     */
    public static String md5(String content, String charset) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return ByteUtil.bytesToHex(md.digest(content.getBytes(charset)));
    }

    /**
     * 获取md5加密后的byte数组
     *
     * @param data 待加密数据
     * @return 加密后的byte数组
     * @throws NoSuchAlgorithmException     {@link NoSuchAlgorithmException}
     * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
     */
    public static byte[] digest(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return digest(data, "UTF-8");
    }

    /**
     * 获取md5加密后的byte数组
     *
     * @param data    待加密数据
     * @param charset 字符集
     * @return 加密后的byte数组
     * @throws NoSuchAlgorithmException     {@link NoSuchAlgorithmException}
     * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
     */
    public static byte[] digest(String data, String charset)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return digest(data.getBytes(charset));
    }

    public static byte[] digest(byte[] data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(data);
        return bytes;
    }


      /**
     * 对文件做摘要
     *
     * @param file 文件
     * @return 摘要
     * @throws IOException              IO异常
     * @throws NoSuchAlgorithmException 不支持的加密类型
     */
    public static String md5(File file) throws IOException, NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = NormalIOUtil.toBytes(fileInputStream);
            return ByteUtil.bytesToHex(md.digest(bytes));
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
}
