package com.tool.utils;

import java.io.*;

/**
 * Created by XM on 2017/9/8.
 */
public class FileIOUtil {

    static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        try {
            String str = new String(readFromFile("D://abc.txt").getBytes());
            System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 读文件 默认编码
     * @param path
     * @return
     * @throws IOException
     */
    public static String readFromFile(String path) throws IOException{
        StringBuffer sbf = new StringBuffer();
        //文件
        Reader reader = null;
        //缓冲区
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(path);
            bufferedReader = new BufferedReader(reader);
            String temp;
            while ((temp = bufferedReader.readLine())!=null){
                sbf.append(temp);
            }

        }catch (IOException e){
            throw new IOException("打开文件失败");
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    throw new IOException("关闭失败");
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    throw new IOException("关闭失败");
                }
            }
        }
        return sbf.toString();
    }

    /**
     * 读文件
     * @param path
     * @param charsetName
     * @return
     * @throws IOException
     */
    public static String readFromFile(String path,String charsetName) throws IOException{
        StringBuffer sbf = new StringBuffer();
        //文件流
        FileInputStream fis = null;
        //文件字符流
        InputStreamReader isr = null;
        //缓冲区
        BufferedReader bufferedReader = null;
        try {
            fis = new FileInputStream(path);
            isr = new InputStreamReader(fis,charsetName);
            bufferedReader = new BufferedReader(isr);
            String temp;
            while ((temp = bufferedReader.readLine())!=null){
                sbf.append(temp);
            }
        }catch (IOException e){
            throw new IOException("读取异常");
        }finally {
            //关闭
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    throw new IOException("关闭失败");
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e1) {
                    throw new IOException("关闭失败");
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    throw new IOException("关闭失败");
                }
            }
        }
        return sbf.toString();
    }

    public void writeToFile(String content){

    }

}
