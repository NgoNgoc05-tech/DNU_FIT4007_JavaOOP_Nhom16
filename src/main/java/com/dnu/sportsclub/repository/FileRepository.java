package com.dnu.sportsclub.repository;

import com.dnu.sportsclub.interfaces.Persistable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRepository<T extends Serializable> implements Persistable<T> {

    private final String fileName;

    public FileRepository(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void save(List<T> data) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(data);
            System.out.println("--> Đã LƯU thành công vào file: " + fileName);
        } catch (IOException e) {
            System.out.println("LỖI LƯU file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<T> load() {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            List<T> data = (List<T>) ois.readObject();
            System.out.println("--> Đã TẢI thành công từ file: " + fileName);
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("LỖI TẢI file: File không tìm thấy.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("LỖI TẢI file: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}