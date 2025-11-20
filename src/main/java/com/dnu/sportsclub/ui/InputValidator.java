package main.java.com.dnu.sportsclub.ui;

import main.java.com.dnu.sportsclub.manager.CompetitionManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputValidator {
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static int readInt(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = sc.nextLine().trim();
                return Integer.parseInt(input);
            }
            catch (Exception e) {
                System.out.println("Lỗi. Vui lòng nhập số nguyên hợp lệ. ");
            }
        }
    }
    public static String readString(String message) {
        while (true) {
            System.out.println(message);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Lỗi. Thông tin này không được để trống. ");
        }
    }
    public static String readDate(String message) {
        while (true) {
            String dateString = readString(message + " yyyy - MM - dd ");
            try {
                LocalDate localDate = LocalDate.parse(dateString, dateTimeFormatter);
                return dateString;
            }
            catch (Exception e) {
                System.out.println("Lỗi. Vui lòng nhập theo Năm - Tháng - Ngày . ");
            }
        }
    }
    public static void pressEnterToContinue() {
        System.out.println("Ấn Enter để tiếp tục. ");
        sc.nextLine();
    }
}
