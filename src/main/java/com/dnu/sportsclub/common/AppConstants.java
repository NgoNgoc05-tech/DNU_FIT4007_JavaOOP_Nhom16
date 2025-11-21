package main.java.com.dnu.sportsclub.common;

public class AppConstants {
    // Tên file lưu trữ dữ liệu (Nên để đuôi .dat vì mình đang lưu Object nhị phân)
    public static final String FILE_MEMBERS = "members.dat";
    public static final String FILE_COACHES = "coaches.dat";
    public static final String FILE_SPORTS = "sports.dat";
    public static final String FILE_SCHEDULES = "schedules.dat";
    public static final String FILE_COMPETITIONS = "competitions.dat";

    // Định dạng ngày giờ chuẩn cho dự án
    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String DATETIME_PATTERN = "dd/MM/yyyy HH:mm";

    // Các thông báo lỗi chung (Optional)
    public static final String ERR_NOT_FOUND = "Không tìm thấy dữ liệu!";
    public static final String ERR_INVALID_INPUT = "Dữ liệu nhập vào không hợp lệ!";
}
