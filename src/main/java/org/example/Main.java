package org.example;

import org.example.stringlist.StringList;
import org.example.stringlist.StringListImpl;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        int storageSize = 10;
        StringList strings = new StringListImpl(storageSize);
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");
        strings.add(4, "ten");
        strings.remove("five");
        for (int i = 0; i < strings.getStorageSize(); i++) {
            System.out.println(strings.get(i));
        }
    }
}