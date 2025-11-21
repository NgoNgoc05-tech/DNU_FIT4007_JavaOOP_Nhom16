package com.dnu.sportsclub;

import com.dnu.sportsclub.ui.MenuManager;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Hệ thống đang khởi động...");
        new MenuManager().start();
    }
}