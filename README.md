# 小车蓝牙模块数据传输解决方案

作者：倪响  邮箱：1870230468@qq.com
---
1. __通过编写蓝牙模块代码发送指定格式数据__
    数据格式要求：front:[ ]left:[ ]right:[ ],在"[ ]"中输出距离数据
2. __手机下载蓝牙调试软件并进行蓝牙调试,建议使用软件“e调试"__
3. __手机打开开发者模式__
4. __电脑上配置mysql数据库(自行搜索相关教程)，并安装adb安卓调试工具__
   [https://dl.google.com/android/repository/platform-tools_r34.0.4-windows.zip]
5. __mysql创建一个新数据库__
```sql
#可以考虑使用原项目配置中的名字cardata
create database cardata;
```
6. __配置target/config.properties文件__
7. __在target文件夹下，打开cmd命令行，运行CarDataDB-3.1.jar文件__
```
java -jar CarDataDB-3.1.jar
```