package com.nx;

import com.nx.dao.CarDataDao;
import com.nx.dao.CarDataDaoImpl;
import com.nx.pojo.CarData;
import com.nx.utils.AdbUtil;
import com.nx.utils.JdbcUtil;

import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("作者:倪响  邮箱:1870230468@bupt.edu.cn");
        System.out.println("------------------------------------------------");
        System.out.println("正在启动服务...");
        CarDataDao carDataDao = new CarDataDaoImpl();
        ExitThread exitThread = new ExitThread();
        exitThread.start();
        while (exitThread.run) {
            JdbcUtil.initDataBase();
            AdbUtil.copyFileFromMobile();
            List<CarData> carDataList = carDataDao.getCarDataList();
            JdbcUtil.saveCarData(carDataList);
            Thread.sleep(1000);
        }
    }
}
