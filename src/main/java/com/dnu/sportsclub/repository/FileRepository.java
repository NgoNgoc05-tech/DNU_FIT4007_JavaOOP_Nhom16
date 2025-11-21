package com.dnu.sportsclub.repository;

import com.dnu.sportsclub.interfaces.Persistable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRepository<T> implements Persistable<T> {
    @Override
    public void save(String fileName, List<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
            System.out.println("--> Đã lưu: " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi lưu file " + fileName);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> load(String fileName) {
        File f = new File(fileName);
        if(!f.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}