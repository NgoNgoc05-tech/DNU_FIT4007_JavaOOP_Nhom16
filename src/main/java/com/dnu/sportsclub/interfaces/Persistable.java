package com.dnu.sportsclub.interfaces;

import java.util.List;

public interface Persistable<T> {
<<<<<<< HEAD
    void save(List<T> data);
    List<T> load();
=======
    void save(String fileName, List<T> data);
    List<T> load(String fileName);
>>>>>>> Quy
}