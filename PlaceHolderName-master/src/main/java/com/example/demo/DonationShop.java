package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class DonationShop {
    private List<Item> itemList = new ArrayList<>();

    public DonationShop() {
        itemList.add(new Item("Donation: 10kg dog food", 50, 1,"dogFood.jpg"));
        itemList.add(new Item("Donation: 20kg dog food", 90, 2, "dogFood.jpg"));
        itemList.add(new Item("Donation: 30kg dog food", 125, 3, "dogFood.jpg"));
        itemList.add(new Item("Donation: Full vaccination of 1 dog", 10, 4, "vaccine.jpg"));
        itemList.add(new Item("Donation: Full vaccination of 5 dogs", 45, 5, "vaccine.jpg"));
        itemList.add(new Item("Donation: Full vaccination of 10 dogs", 80, 6, "vaccine.jpg"));
    }

    public Item getItem(int id) {
        for (Item i : itemList) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public List<Item> getAllItems() {

        return itemList;
    }
}
