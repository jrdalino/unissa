package com.unissa.adapter;

import java.util.ArrayList;
import java.util.List;

public class CsvAdapter implements StorageInterface { // Adapter

    @Override
    public List<Category> load(){
        CsvAdaptee csvAdaptee = new CsvAdaptee();

        csvAdaptee.openFile();
        csvAdaptee.readLine();
        csvAdaptee.csvToObject(); // categories =  csvAdaptee.csvToObject()
        csvAdaptee.closeFile();

        // Mock for now
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("1", "Category A - CSV"));
        categories.add(new Category("2", "Category B - CSV"));
        categories.add(new Category("3", "Category C - CSV"));

        return categories;
    }

    @Override
    public void store(List<Category> categories){
        CsvAdaptee csvAdaptee = new CsvAdaptee();

        csvAdaptee.openFile();
        csvAdaptee.objectToCSV(); // Pass categories to function
        csvAdaptee.writeLine();
        csvAdaptee.closeFile();

        // Mock for now
        System.out.println("Saving to CSV");
    }
}
