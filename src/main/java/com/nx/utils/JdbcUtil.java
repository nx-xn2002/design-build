package com.nx.utils;

import com.nx.pojo.CarData;

import java.sql.*;
import java.util.List;


public class JdbcUtil {
    public static void initDataBase() {
        String url = PropertiesUtil.getPropertyByName("url");
        String username = PropertiesUtil.getPropertyByName("username");
        String password = PropertiesUtil.getPropertyByName("password");
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql1 = "drop table if exists car";
            String sql2 = "CREATE TABLE IF NOT EXISTS car\n" +
                    "(\n" +
                    "    id             int auto_increment primary key,\n" +
                    "    time           float,\n" +
                    "    front_distance float,\n" +
                    "    left_distance  float,\n" +
                    "    right_distance float,\n" +
                    "    url            varchar(255)\n" +
                    ")";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载失败");
        } catch (Exception e) {
            System.out.println("数据库初始化失败，请检查数据库连接");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveCarData(List<CarData> carDataList) {
        String url = PropertiesUtil.getPropertyByName("url");
        String username = PropertiesUtil.getPropertyByName("username");
        String password = PropertiesUtil.getPropertyByName("password");
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            String sql = "insert into car(time,front_distance,left_distance,right_distance,url) " +
                    "values(?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            for (int index = 0; index < carDataList.size(); index++) {
                CarData carData = carDataList.get(index);
                ps.setFloat(1, carData.getTime());
                ps.setFloat(2, carData.getDistanceFront());
                ps.setFloat(3, carData.getDistanceLeft());
                ps.setFloat(4, carData.getDistanceRight());
                ps.setString(5, carData.getUrl());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载失败");
            return;
        } catch (Exception e) {
            System.out.println("数据库更新失败");
            return;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("数据更新成功，现有数据" + carDataList.size() + "条");
    }
}
