package com.nx;

import com.nx.utils.AdbUtil;
import com.nx.utils.PropertiesUtil;
import com.nx.utils.TxtUtil;
import org.junit.Test;

import java.io.IOException;

public class AppTest {
    @Test
    public void test(){
        System.out.println(TxtUtil.getLatestFile(PropertiesUtil.getPropertyByName("CarData") + "\\eDebugger"));
    }
}