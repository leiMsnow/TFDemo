package com.ray.tf.demo.tfsdk;

import android.util.Log;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileEncAndDec {
    private static final int numOfEncAndDec = 0x99; //加密解密秘钥
    private static int dataOfFile = 0; //文件字节内容

//    public static void main(String[] args) {
//
//        File srcFile = new File("/Users/maomaozhou/tensorflow/file/k"); //初始文件
//        File encFile = new File("/Users/maomaozhou/tensorflow/file/k-e"); //加密文件
//        File decFile = new File("/Users/maomaozhou/tensorflow/file/k-d"); //解密文件
//
//        try {
//            EncFile(srcFile, encFile); //加密操作
//
//            EncFile(encFile, decFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void EncFile(File srcFile, File encFile) throws Exception {
        if (!srcFile.exists()) {
            Log.e("i", "source file not exist");
            return;
        }

        if (!encFile.exists()) {
            Log.e("i", "encrypt file created");
            encFile.createNewFile();
        }
        InputStream fis = new FileInputStream(srcFile);
        OutputStream fos = new FileOutputStream(encFile);
        int i = 0;
        byte[] buff = new byte[1024];
        int bytesRead;

        while ((bytesRead = fis.read(buff)) > -1) {
            if (i++ == 0) {
                if (bytesRead < 1024) {
                    for (int j = 0; j < bytesRead; j++) {
                        fos.write(buff[j] ^ numOfEncAndDec);
                    }
                } else {
                    for (int j = 0; j < buff.length; j++) {
                        fos.write(buff[j] ^ numOfEncAndDec);
                    }
                }
            } else {
                fos.write(buff, 0, bytesRead);
            }
        }
        fis.close();
        fos.flush();
        fos.close();
    }


    public static String EncFile(InputStream fis, String encFile) throws Exception {

        File file = new File(encFile);
        if (!file.exists()) {
            Log.e("i", "encrypt file created");
            file.createNewFile();
        }
//        InputStream fis = new FileInputStream(srcFile);
        OutputStream fos = new FileOutputStream(encFile);
        int i = 0;
        byte[] buff = new byte[1024];
        int bytesRead;

        while ((bytesRead = fis.read(buff)) > -1) {
            if (i++ == 0) {
                if (bytesRead < 1024) {
                    for (int j = 0; j < bytesRead; j++) {
                        fos.write(buff[j] ^ numOfEncAndDec);
                    }
                } else {
                    for (int j = 0; j < buff.length; j++) {
                        fos.write(buff[j] ^ numOfEncAndDec);
                    }
                }
            } else {
                fos.write(buff, 0, bytesRead);
            }
        }
        fis.close();
        fos.flush();
        fos.close();

        return encFile;
    }
}