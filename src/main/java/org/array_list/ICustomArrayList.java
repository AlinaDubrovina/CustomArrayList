package org.array_list;
/**
 * The ICustomArrayList interface for simple operations with a dynamic array.
 *
 * @param <T> the type of elements the array contains.
 */
public interface ICustomArrayList<T>{
    /**
     * Adds the specified element to the end of the list.
     *
     * @param element the element to be added.
     */
    void add(Object element);


    /**
     * Inserts the specified element at the specified position in the list.
     *
     * @param index   the index at which the element is to be inserted.
     * @param element the element to be inserted.
     */
    void add(int index, Object element);

    /**
     * Returns the element at the specified position in the list.
     *
     * @param index the index of the element to return.
     * @return the element at the specified index.
     */
    Object get(int index);


    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element the element to be removed.
     */
    void deleteFirstOccurrence(Object element);

    /**
     * Removes all elements from the list, making it empty.
     */
    void deleteAll();

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list.
     */
    int size();

    /**
     * Updates the value at the specified index with a new element.
     *
     * @param index      the index of the element to be updated.
     * @param newElement the new element to replace the existing one.
     */
    void updateValue(int index, Object newElement);
}
