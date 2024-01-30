package org.array_list;

import java.util.NoSuchElementException;

/**
 * CustomArrayList class is a simple implementation of a dynamic array.
 * It provides methods for adding and removing elements.
 *
 * @param <T> the type of elements the array contains.
 */
public class CustomArrayList<T extends Comparable<T>>  implements ICustomArrayList<T>{
    /**
     * The internal array storing elements of type T.
     */
    private Object[] values;

    /**
     * Constructs an empty CustomArrayList.
     */
    public CustomArrayList() {
        values = new Object[0];
    }

    @Override
    public void add(Object element) {
        increaseCapacity();
        values[values.length - 1] = element;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > values.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + values.length);
        }

        Object[] temp = values;
        values = new Object[temp.length + 1];

        System.arraycopy(temp, 0, values, 0, index);

        values[index] = element;

        int amountElementsAfterIndex = temp.length - index;
        System.arraycopy(temp, index, values, index + 1, amountElementsAfterIndex);
    }

    @Override
    public Object get(int index) {
        return values[index];
    }

    @Override
    public void deleteFirstOccurrence(Object element) {
        int indexToDelete = -1;

        for (int i = 0; i < values.length; i++) {
            if (values[i] != null && values[i].equals(element)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) {
            Object[] temp = values;
            values = new Object[temp.length - 1];

            System.arraycopy(temp, 0, values, 0, indexToDelete);

            int amountElementsAfterIndex = temp.length - indexToDelete - 1;
            System.arraycopy(temp, indexToDelete + 1, values, indexToDelete, amountElementsAfterIndex);
        } else {
            throw new NoSuchElementException("Element to delete not found");
        }
    }

    @Override
    public void deleteAll() {
        values = new Object[0];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void updateValue(int index, Object newElement) {
        values[index] = newElement;
    }

    /**
     * Increases the capacity of the array by one, preserving existing elements.
     */
    private void increaseCapacity() {
        Object[] temp = values;
        values = new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
    }
}
