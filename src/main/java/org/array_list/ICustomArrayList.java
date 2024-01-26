package org.array_list;

public interface ICustomArrayList<E>{
    void add(E element);
    void add(int index, E element);
    E get(int index);
    void deleteFirstOccurrence(E element);
    void deleteAll();
    int size();

}
