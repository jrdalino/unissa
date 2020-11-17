package com.unissa.adapter;

import java.util.ArrayList;
import java.util.List;

public class Inventory { // Client
    public List<Category> categories = new ArrayList<>();

    public Inventory() {
    }

    public List<Category> load(String storageType) {
        if (storageType == "csv") {
            CsvAdapter csvAdapter = new CsvAdapter();
            categories = csvAdapter.load();
        }
        else if (storageType == "xml") {
            XmlAdapter xmlAdapter = new XmlAdapter();
            categories = xmlAdapter.load();
        }
        return categories;
    }

    public void store(String storageType, List<Category> categories) {
        if (storageType == "csv") {
            CsvAdapter csvAdapter = new CsvAdapter();
            csvAdapter.store(categories);
        }
        else if (storageType == "xml") {
            XmlAdapter xmlAdapter = new XmlAdapter();
            xmlAdapter.store(categories);
        }
    }

    public List<Category> getAllCategories() {
        return this.categories;
    }
}
