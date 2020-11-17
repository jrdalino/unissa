package com.unissa.adapter;

import java.util.List;

public interface StorageInterface { // Target
    List<Category> load();
    void store(List<Category> categories);
}
