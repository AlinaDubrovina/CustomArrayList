package org.array_list.quick_sort;

import org.array_list.CustomArrayList;

/**
 * The QuickSort class provides an implementation of the QuickSort algorithm for sorting elements in a CustomArrayList.
 *
 * @param <T> the type of elements that the QuickSort can sort, must implement Comparable.
 */
public class QuickSort<T extends Comparable<T>> {
    /**
     * Sorts the elements in the CustomArrayList using the QuickSort algorithm.
     *
     * @param customArrayList the custom array list to be sorted.
     * @param beginning       the starting index of the range to be sorted.
     * @param end             the ending index of the range to be sorted.
     */
    public void sort(CustomArrayList<T> customArrayList, int beginning, int end) {
        if (beginning < end) {
            int partitionIndex = partition(customArrayList, beginning, end);

            sort(customArrayList, beginning, partitionIndex - 1);
            sort(customArrayList, partitionIndex + 1, end);
        }
    }

    /**
     * Partitions the CustomArrayList into two halves around a pivot element.
     *
     * @param customArrayList the CustomArrayList to be partitioned.
     * @param begin           the starting index of the partition range.
     * @param end             the ending index of the partition range.
     * @return the index of the pivot element after partitioning.
     */
    private int partition(CustomArrayList<T> customArrayList, int begin, int end) {
        T pivot = (T) customArrayList.get(end);
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (pivot.compareTo((T) customArrayList.get(j)) >= 0) {
                i++;

                Object swapTemp = customArrayList.get(i);
                customArrayList.updateValue(i, customArrayList.get(j));
                customArrayList.updateValue(j, swapTemp);
            }
        }

        T swapTemp = (T) customArrayList.get(i + 1);
        customArrayList.updateValue(i + 1, customArrayList.get(end));
        customArrayList.updateValue(end, swapTemp);

        return i + 1;
    }
}