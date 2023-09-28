package com.nx;

import java.util.Scanner;

public class ExitThread extends Thread{
    public boolean run = true;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (true){
            if(input==1){
                run = false;
            }
            input = scanner.nextInt();
        }
    }
}
