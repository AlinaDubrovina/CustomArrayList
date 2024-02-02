package org.array_list;

import java.util.NoSuchElementException;

/**
 * CustomArrayList class is a simple implementation of a dynamic array.
 * It provides methods for adding and removing elements.
 *
 * @param <T> the type of elements the array contains.
 */
public class CustomArrayList<T extends Comparable<T>>  implements ICustomArrayList<T> {

    private static final String OUT_OF_BOUND_ERR_MSG = "Index: %d, Size: %d";
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
            // подобного рода форматирование лучше делать через String.format + все текстовые сообщения выносим в статические константы
            throw new IndexOutOfBoundsException(String.format(OUT_OF_BOUND_ERR_MSG, index, values.length));
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
        return values[index]; // тут ведь тоже может быть IndexOutOfBoundsException, но это мелочи
    }

    @Override
    public void deleteFirstOccurrence(Object element) {
        if (element == null) { //если нул то мы ничего не сможем удалить
            return;
        }

        int indexToDelete = -1;

        for (int i = 0; i < values.length; i++) {
            if (element.equals(values[i])) { // обрати внимание на то, что я вызываю equals на element и мне не надо проверять текущий элемент массива на нул
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
