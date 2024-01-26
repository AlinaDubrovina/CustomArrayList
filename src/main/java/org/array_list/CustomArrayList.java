package org.array_list;

import java.util.NoSuchElementException;

public class CustomArrayList<E> implements ICustomArrayList<E> {
    private E[] values;

    public CustomArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public void add(E element) {
        increaseCapacity();
        values[values.length - 1] = element;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > values.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + values.length);
        }

        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];

        System.arraycopy(temp, 0, values, 0, index);

        values[index] = element;

        int amountElementsAfterIndex = temp.length - index;
        System.arraycopy(temp, index, values, index + 1, amountElementsAfterIndex);
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public void deleteFirstOccurrence(E element) {
        int indexToDelete = -1;

        for (int i = 0; i < values.length; i++) {
            if (values[i] != null && values[i].equals(element)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];

            System.arraycopy(temp, 0, values, 0, indexToDelete);

            int amountElementsAfterIndex = temp.length - indexToDelete - 1;
            System.arraycopy(temp, indexToDelete + 1, values, indexToDelete, amountElementsAfterIndex);
        } else {
            throw new NoSuchElementException("Element to delete not found");
        }
    }

    @Override
    public void deleteAll() {
        values = (E[]) new Object[0];
    }

    @Override
    public int size() {
        return values.length;
    }

    private void increaseCapacity() {
        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
    }
}
