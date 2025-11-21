package com.dnu.sportsclub.interfaces;

import java.util.List;

public interface Persistable<T> {
    void save(String fileName, List<T> data);
    List<T> load(String fileName);
}