package com.nx.utils;

import com.nx.pojo.CarData;

import java.io.IOException;

public class AdbUtil {
    public static void checkConnection() {
        String cmd = "adb devices";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            System.out.println("连接异常");
        }
        int exitCode = 0;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            System.out.println("线程异常");
        }
        if (exitCode == 0) {
            System.out.println("设备连接正常");
        } else {
            System.out.println("与设备连接失败");
        }
    }

    public static void copyFileFromMobile() {
        checkConnection();
        String cmd = "adb pull " + PropertiesUtil.getPropertyByName("MobilePath") + " " + PropertiesUtil.getPropertyByName("CarData");
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            System.out.println("连接异常");
        }
        int exitCode = 0;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            System.out.println("线程异常");
        }
        if (exitCode == 0) {
            System.out.println("文件更新成功");
        } else {
            System.out.println("文件更新失败");
        }
    }
}
