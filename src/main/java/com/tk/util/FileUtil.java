package com.tk.util;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author taoke
 * @date 2021-8-30 21:37:20
 * @description 文件读取工具类
 */
public class FileUtil {

    /**
     * 具体读取文件内容
     *
     * @param path 文件路径
     * @return 内容
     */
    public static String readTextContent(String path) {
        //获取项目根路径
        String fileName = System.getProperty("user.dir");
        String s = readFileContent(fileName + path);
        return StringUtils.isEmpty(s) ? "" : s;
    }

    /**
     * 具体读取文件内容
     *
     * @param path 文件路径
     * @return 内容
     */
    private static String readFileContent(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
}
