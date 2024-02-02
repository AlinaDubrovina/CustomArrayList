package org.array_list.quick_sort;

import org.array_list.CustomArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// тесты норм, единственное, в следующий раз тести пограничные состояния
// например как сортируется уже отсортированный массив? или если там 1 элемент?
public class QuickSortTest {
    private QuickSort<String> quickSort1;
    private CustomArrayList<String> customArrayList1;
    private QuickSort<Integer> quickSort2;
    private CustomArrayList<Integer> customArrayList2;
    @BeforeEach
    public void init(){
        quickSort1 = new QuickSort<>();
        customArrayList1 = new CustomArrayList<>();
        customArrayList1.add("Hi");
        customArrayList1.add("Hello");
        customArrayList1.add("Ok");
        customArrayList1.add("Hello World");

        quickSort2 = new QuickSort<>();
        customArrayList2 = new CustomArrayList<>();
        customArrayList2.add(1);
        customArrayList2.add(2);
        customArrayList2.add(0);
        customArrayList2.add(6);
        customArrayList2.add(4);
    }

    @Test
    @DisplayName("quickSortStringTest")
    public void quickSortStringTest() {
        quickSort1.sort(customArrayList1, 0, customArrayList1.size() - 1);

        String[] expected = {"Hello", "Hello World", "Hi", "Ok"};

        String[] actual = new String[customArrayList1.size()];
        for (int i = 0; i < customArrayList1.size(); i++) {
            actual[i] = (String) customArrayList1.get(i);
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("quickSortIntTest")
    public void quickSortIntTest() {
        Integer[] expected = {0, 1, 2, 4, 6};
        quickSort2.sort(customArrayList2, 0, customArrayList2.size() - 1);

        Integer[] actual = new Integer[customArrayList2.size()];
        for (int i = 0; i < customArrayList2.size(); i++) {
            actual[i] = (Integer) customArrayList2.get(i);
        }

        Assertions.assertArrayEquals(expected, actual);
    }
}
