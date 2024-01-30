package org.array_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {
    private CustomArrayList<String> customArrayList1;
    private CustomArrayList<Integer> customArrayList2;

    @BeforeEach
    public void init(){
        customArrayList1 = new CustomArrayList<>();
        customArrayList1.add("Hi");
        customArrayList1.add("Hello");
        customArrayList1.add("Hello World");
        customArrayList1.add("Ok");

        customArrayList2 = new CustomArrayList<>();
        customArrayList2.add(0);
        customArrayList2.add(1);
        customArrayList2.add(2);
        customArrayList2.add(3);
        customArrayList2.add(4);
    }

    @Test
    @DisplayName("addStringsTest")
    void addStringsTest() {
        int sizeBeforeAdding = customArrayList1.size();
        String elementToAdd = "привет";

        customArrayList1.add(elementToAdd);

        assertEquals(sizeBeforeAdding + 1, customArrayList1.size());
    }
    @Test
    @DisplayName("addIntegerTest")
    void addIntegerTest() {
        int initialSize = customArrayList2.size();

        customArrayList2.add(5);

        assertEquals(initialSize + 1, customArrayList2.size());
    }

    @Test
    @DisplayName("sizeTest")
    void sizeTest() {
        int actual = customArrayList1.size();

        assertEquals(4, actual);
    }

    @Test
    @DisplayName("addAtIndexTest")
    void addAtIndexTest() {
        int sizeBeforeAdding = customArrayList1.size();
        String elementToAdd = "Apple";
        customArrayList1.add(3, "Apple");

        assertEquals(sizeBeforeAdding + 1, customArrayList1.size());
        assertEquals(elementToAdd, customArrayList1.get(3));
    }

    @Test
    @DisplayName("getByIndex")
    void getByIndexTest() {
        Object elementAtIndex0 = customArrayList2.get(0);
        Object elementAtIndex1 = customArrayList2.get(1);
        Object elementAtIndex2 = customArrayList2.get(2);
        Object elementAtIndex3 = customArrayList2.get(3);

        assertEquals(0, elementAtIndex0);
        assertEquals(1, elementAtIndex1);
        assertEquals(2, elementAtIndex2);
        assertEquals(3, elementAtIndex3);
    }

    @Test
    @DisplayName("deleteFirstOccurrenceTest")
    void deleteFirstOccurrenceTest() {
        customArrayList2.add(2);
        customArrayList2.add(7);

        customArrayList2.deleteFirstOccurrence(2);
        assertEquals(customArrayList2.get(2), 3);
    }

    @Test
    @DisplayName("deleteAllTest")
    void deleteAllTest() {
        customArrayList1.deleteAll();

        assertEquals(0, customArrayList1.size());
    }

    @Test
    @DisplayName("updateValueTest")
    void updateValueTest() {
        customArrayList1.updateValue(1, "Peanut");

        assertEquals(customArrayList1.get(1), "Peanut");
    }
}
