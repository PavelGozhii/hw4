package com.company;

public class MyArrayList<T> implements MyList<T> {

    private T[] arr;
    private int size;

    public MyArrayList() {
        size = 0;
        arr = (T[]) new Object[size];
    }

    public MyArrayList(T[] arr) {
        this.arr = arr;
        size = arr.length;
    }

    @Override
    public void add(T value) {
        if (size < arr.length) {
            arr[size] = value;
            size++;
        } else {
            T[] newArr = (T[]) new Object[size + 1];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            newArr[size] = value;
            arr = newArr;
            size++;
        }
    }

    @Override
    public void add(T value, int index) {
        if (index == (size - 1)) {
            add(value);
        } else {
            int sizeArr;
            if (size < arr.length) {
                sizeArr = this.arr.length;
            } else {
                sizeArr = this.size + 1;
            }
            T[] newArr = (T[]) new Object[sizeArr];
            int element = 0;
            for (int i = 0; i < this.size + 1; i++) {
                if (i == index) {
                    newArr[i] = value;
                } else {
                    newArr[i] = arr[element];
                    element++;
                }
            }
            arr = newArr;
            size++;
        }
    }

    @Override
    public void addAll(MyList list) {
        if (list.size() == 1) {
            add((T) list.get(0));
        } else if (list.size() != 0) {
            int sizeArr = size + list.size();
            int element = 0;
            if (sizeArr < arr.length) {
                for (int i = arr.length - 1; i < sizeArr; i++) {
                    arr[i] = (T) list.get(element);
                    element++;
                }
            } else {
                T[] newArr = (T[]) new Object[sizeArr];
                for (int i = 0; i < arr.length; i++) {
                    newArr[element] = arr[i];
                    element++;
                }
                for (int i = 0; i < list.size(); i++) {
                    newArr[element] = (T) list.get(i);
                    element++;
                }
                arr = newArr;
            }
            size = sizeArr;
        }
    }

    @Override
    public T get(int index) {
        return arr[index];
    }

    @Override
    public void set(T value, int index) {
        this.arr[index] = value;
    }

    @Override
    public T remove(int index) {
        size--;
        if (index != (size)) {
            T[] newArr = (T[]) new Object[size];
            int element = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i != index) {
                    newArr[element] = arr[i];
                    element++;
                }
            }
            arr = newArr;
        }
        return arr[index];
    }

    @Override
    public T remove(T value) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (value.equals(arr[i])) {
                index = i;
                break;
            }
        }
        return remove(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(arr[0].toString());
        for (int i = 1; i < size; i++) {
            result.append(", ").append(arr[i]);
        }
        return result.toString();
    }
}
