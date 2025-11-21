package main.java.com.dnu.sportsclub.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Thêm "implements Persistable<T>" vào đây
public class FileRepository<T> implements Persistable<T> {

    @Override // Ghi đè phương thức save của Interface
    public void save(String fileName, List<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
            System.out.println("--> Đã lưu file: " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi lưu file " + fileName + ": " + e.getMessage());
        }
    }

    @Override // Ghi đè phương thức load của Interface
    @SuppressWarnings("unchecked")
    public List<T> load(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            // Nếu lỗi đọc file (file cũ hoặc lỗi version), trả về list rỗng
            return new ArrayList<>();
        }
    }
}