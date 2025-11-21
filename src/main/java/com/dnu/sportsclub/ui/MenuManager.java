package main.java.com.dnu.sportsclub.ui;

public class MenuManager {
    public void run(){
        while(true){
            printMainMenu();
            int choice = InputValidator.readInt("Mời bạn chọn chức năng");
            switch(choice){
                case 1:
                    System.out.println("\n--- QUẢN LÝ THÀNH VIÊN ---");
                    System.out.println("(Chức năng đang phát triển...)");
                    break;
                case 2:
                    System.out.println("\n--- QUẢN LÝ HUẤN LUYỆN VIÊN ---");
                    System.out.println("(Chức năng đang phát triển...)");
                    break;
                case 3:
                    System.out.println("\n--- QUẢN LÝ MÔN THỂ THAO ---");
                    System.out.println("(Chức năng đang phát triển...)");
                    break;
                case 4:
                    System.out.println("\n--- QUẢN LÝ LỊCH TẬP ---");
                    System.out.println("(Chức năng đang phát triển...)");
                    break;
                case 5:
                    System.out.println("\n--- QUẢN LÝ GIẢI ĐẤU ---");
                    System.out.println("(Chức năng đang phát triển...)");
                    break;
                case 6:
                    System.out.println("\n--- BÁO CÁO VÀ THỐNG KÊ ---");
                    System.out.println("(Chức năng đang phát triển...)");
                    break;
                case 0:
                    System.out.println("Đang Lưu Dữ Liệu Và Thoát Chương Trình ...");
                    break;
                default:
                    System.out.println("Lỗi! Vui lòng lựa chọn từ 0 đến 6 . ");
            }
            InputValidator.pressEnterToContinue();
        }
    }

    private void printMainMenu() {
        System.out.println("\n============================================");
        System.out.println("   HỆ THỐNG QUẢN LÝ CÂU LẠC BỘ THỂ THAO   ");
        System.out.println("============================================");
        System.out.println("1. Quản lí thành viên. ");
        System.out.println("2. Quản lí huấn luyện viên. ");
        System.out.println("3. Quản lí môn thể thao");
        System.out.println("4. Quản lí lịch tập. ");
        System.out.println("5. Quản lí giải đấu. ");
        System.out.println("6. Báo cáo và thống kê. ");
        System.out.println("0. Thoát! ");
        System.out.println("============================================");
    }
}
