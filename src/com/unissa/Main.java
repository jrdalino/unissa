package com.unissa;

import com.unissa.adapter.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /** Adapter Pattern **/
        // Adapter Pattern: ManageInventoryControl

        // Call Inventory.store()
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("1", "Category A"));
        categories.add(new Category("2", "Category B"));
        categories.add(new Category("3", "Category C"));

        Inventory inventory = new Inventory();

        inventory.store("csv", categories);
        inventory.store("xml", categories);

        // Call Inventory.load()
        categories.clear(); // Initialise & Validate if empty
        System.out.println(categories);

        categories = inventory.load("csv");
        categories.forEach((category) -> System.out.println(category.name));

        categories.clear(); // Initialise & Validate if empty
        System.out.println(categories);

        categories = inventory.load("xml");
        categories.forEach((category) -> System.out.println(category.name));
    }
}
