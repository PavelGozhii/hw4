package com.company;

public class Main {

    public static void main(String[] args) {
        MyList<String> myArrayList = new MyArrayList<>();
        System.out.println(myArrayList);
        myArrayList.add("Привет");
        myArrayList.add("Я джун");
        myArrayList.add("Пока");
        myArrayList.add("Но я могу!", 2);

        MyList<String> myArrayList1 = new MyArrayList<>();
        myArrayList1.add("Hello");
        myArrayList1.add("...");
        myArrayList1.add("Goodbuy", 2);
        myArrayList.addAll(myArrayList1);
        myArrayList.add("Omg", 3);
        myArrayList.remove("Пока");

        System.out.println(myArrayList);

    }
}
