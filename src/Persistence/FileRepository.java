package main.java.com.dnu.sportsclub.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRepository {

    public static <T> void save(List<T> data, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
            System.out.println("Lưu dữ liệu vào " + fileName + " thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> load(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("Tải dữ liệu từ " + fileName + ".");
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " không tồn tại. Khởi tạo danh sách trống.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi tải file. Trả về danh sách trống.");
            return new ArrayList<>();
        }
    }
}