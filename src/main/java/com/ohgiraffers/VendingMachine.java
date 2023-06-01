package com.ohgiraffers;

import java.util.*;

public class VendingMachine {
    ArrayList<Item> items= new ArrayList<>();

    public VendingMachine() {
        Item item = new Item("사이다");
        items.add(item);
    }

    String str = null;
    public void addObjectToVM(String object) {
        Item item = new Item(object);
        items.add(item);
    }

    public void removeObjectToVM(String object) {
        for (int i = 0; i <= items.size(); i++) {
            if (items.get(i).name.equals(object)) {
                items.remove(i);
                break;
            }
        }
    }

    public void showObjectsToVM() {
        this.str = null;
        int size = 0;
        for (int i = 0; i <= this.items.size(); i++) {
            this.str = this.items.get(i).name + ", ";
        }
        System.out.println(str);
    }

    public boolean foundItemToVM(String name) {
        if (items.size() != 0) {
            for (int i = 0; i <= this.items.size(); i++) {
                if (this.items.get(i).name.equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}
