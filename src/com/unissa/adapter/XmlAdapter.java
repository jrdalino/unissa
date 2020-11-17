package com.unissa.adapter;

import java.util.ArrayList;
import java.util.List;

public class XmlAdapter implements StorageInterface { // Adapter

    @Override
    public List<Category> load(){
        XmlAdaptee xmlAdaptee = new XmlAdaptee();

        xmlAdaptee.openFile();
        xmlAdaptee.readLine();
        xmlAdaptee.xmlToObject(); // categories =  xmlAdaptee.xmlToObject()
        xmlAdaptee.closeFile();

        // Mock for now
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("1", "Category A - XML"));
        categories.add(new Category("2", "Category B - XML"));
        categories.add(new Category("3", "Category C - XML"));

        return categories;
    }

    @Override
    public void store(List<Category> categories) {
        XmlAdaptee xmlAdaptee = new XmlAdaptee();

        xmlAdaptee.openFile();
        xmlAdaptee.objectToXML(); // Pass categories to function
        xmlAdaptee.writeLine();
        xmlAdaptee.closeFile();

        // Mock for now
        System.out.println("Saving to XML");
    }
}

