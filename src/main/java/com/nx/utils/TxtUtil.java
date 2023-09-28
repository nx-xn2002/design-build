package com.nx.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtUtil {

    public static File getLatestFile(String path) {
        File folder = new File(path);
        if (!folder.isDirectory()) {
            System.out.println("指定路径不是一个文件夹");
            return null;
        }
        File[] files = folder.listFiles();
        if (files.length == 0) {
            System.out.println("文件夹中没有文件");
            return null;
        }
        File res = null;
        long max = 0;
        String regex = "(.*)\\.txt";
        Pattern pattern = Pattern.compile(regex);
        for (File file : files) {
            Matcher matcher = pattern.matcher(file.getName());
            if (matcher.find()) {
                long temp = Long.parseLong(matcher.group(1));
                if (temp > max) {
                    res = file;
                    max = temp;
                }
            }
        }
        return res;
    }

    public static String getSource() {
        File carData = getLatestFile(PropertiesUtil.getPropertyByName("CarData") + "\\eDebugger");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(carData));
            String data = br.readLine();
            while (data != null) {
                sb.append(data);
                data = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("日志文件读取异常..");
        }
        return sb.toString();
    }
}
