package org.array_list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {
    static Stream<Arguments> provideArgumentsForCustomArrayList() {
        return Stream.of(
                Arguments.of(new CustomArrayList<String>()),
                Arguments.of(new CustomArrayList<Integer>()),
                Arguments.of(new CustomArrayList<>())
        );
    }

    @ParameterizedTest(name = "addStringsTest")
    @MethodSource("provideArgumentsForCustomArrayList")
    @DisplayName("addStringsTest")
    void addStringsTest(CustomArrayList<String> customArrayList) {
        int initialSize = customArrayList.size();
        String elementToAdd1 = "привет";
        String elementToAdd2 = "пока";

        customArrayList.add(elementToAdd1);
        customArrayList.add(elementToAdd2);

        assertEquals(initialSize + 2, customArrayList.size());
        assertEquals(elementToAdd1, customArrayList.get(customArrayList.size() - 2));
        assertEquals(elementToAdd2, customArrayList.get(customArrayList.size() - 1));
    }

    @ParameterizedTest(name = "addIntegerTest")
    @MethodSource("provideArgumentsForCustomArrayList")
    @DisplayName("addIntegerTest")
    void addIntegerTest(CustomArrayList<Integer> customArrayList) {
        int initialSize = customArrayList.size();

        int elementToAdd1 = 1;
        int elementToAdd2 = 2;
        int elementToAdd3 = 3;


        customArrayList.add(elementToAdd1);
        customArrayList.add(elementToAdd2);
        customArrayList.add(elementToAdd3);

        assertEquals(initialSize + 3, customArrayList.size());
        assertEquals(elementToAdd1, customArrayList.get(customArrayList.size() - 3));
        assertEquals(elementToAdd2, customArrayList.get(customArrayList.size() - 2));
        assertEquals(elementToAdd3, customArrayList.get(customArrayList.size() - 1));
    }

    @ParameterizedTest(name = "sizeTest")
    @MethodSource("provideArgumentsForCustomArrayList")
    @DisplayName("sizeTest")
    void sizeTest(CustomArrayList<Integer> customArrayList) {
        int initialSize = customArrayList.size();

        int elementToAdd1 = 1;
        int elementToAdd2 = 2;
        int elementToAdd3 = 3;

        customArrayList.add(elementToAdd1);
        customArrayList.add(elementToAdd2);
        customArrayList.add(elementToAdd3);

        assertEquals(initialSize + 3, customArrayList.size());
    }

    @ParameterizedTest(name = "addAtIndexTest")
    @MethodSource("provideArgumentsForCustomArrayList")
    @DisplayName("addAtIndexTest")
    void addAtIndexTest(CustomArrayList<Integer> customArrayList) {
        customArrayList.add(0);
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        int sizeBeforeAdding = customArrayList.size();
        int indexToAdd = 2;
        int elementToAdd = 2;

        customArrayList.add(indexToAdd, elementToAdd);

        assertEquals(sizeBeforeAdding + 1, customArrayList.size());
        assertEquals(elementToAdd, customArrayList.get(indexToAdd));
    }

    @ParameterizedTest(name = "getByIndex")
    @MethodSource("provideArgumentsForCustomArrayList")
    @DisplayName("getByIndex")
    void getByIndexTest(CustomArrayList<Integer> customArrayList) {
        customArrayList.add(0);
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        Object elementAtIndex0 = customArrayList.get(0);
        Object elementAtIndex1 = customArrayList.get(1);
        Object elementAtIndex2 = customArrayList.get(2);
        Object elementAtIndex3 = customArrayList.get(3);

        assertEquals(0, elementAtIndex0);
        assertEquals(1, elementAtIndex1);
        assertEquals(2, elementAtIndex2);
        assertEquals(3, elementAtIndex3);
    }

    @ParameterizedTest(name = "deleteFirstOccurrenceTest")
    @MethodSource("provideArgumentsForCustomArrayList")
    @DisplayName("deleteFirstOccurrenceTest")
    void deleteFirstOccurrenceTest(CustomArrayList<Integer> customArrayList) {
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        customArrayList.deleteFirstOccurrence(2);
        assertEquals(customArrayList.get(1), 3);

        Throwable exception = assertThrows(NoSuchElementException.class, () -> customArrayList.deleteFirstOccurrence(5));

        assert("Element to delete not found".equals(exception.getMessage()));
    }

    @ParameterizedTest(name = "deleteAllTest")
    @MethodSource("provideArgumentsForCustomArrayList")
    void deleteAllTest(CustomArrayList<Integer> customArrayList) {
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        customArrayList.deleteAll();

        assertEquals(0, customArrayList.size());
    }
}