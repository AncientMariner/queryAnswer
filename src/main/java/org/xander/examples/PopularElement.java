package org.xander.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PopularElement {
    int[] sortedArray;
    int popularityIndex;
    Map<Integer, Integer> numberForEachElement;

    public PopularElement(int[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) {
            throw new IllegalStateException("data is not filled, not able to check");
        }
        this.sortedArray = sortedArray;
        this.popularityIndex = sortedArray.length / 4;
        numberForEachElement = new HashMap<>();
    }

    public double getPopularityIndex() {
        return popularityIndex;
    }

    public int getPopularElementMapWay() {
        for (int elem : sortedArray) {
            if (numberForEachElement.get(elem) != null) {
                numberForEachElement.put(elem, numberForEachElement.get(elem) + 1);
            } else {
                numberForEachElement.put(elem, 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = numberForEachElement.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> element = iterator.next();
            if (element.getValue() >= popularityIndex) {
                return element.getKey();
            }
        }
        return 0;
    }

    public int getNumberBySearch(int number) {
        return Arrays.binarySearch(sortedArray, number);
    }

    public int findPopularElement() {
        int popularElement = 0;
        int arrayLength = sortedArray.length;
        if (arrayLength / 8 != getNumberBySearch(sortedArray[arrayLength / 8])) {
            popularElement = sortedArray[arrayLength / 8];
        }
        if (arrayLength / 4 != getNumberBySearch(sortedArray[arrayLength / 4])) {
            popularElement = sortedArray[arrayLength / 4];
        }
        if (arrayLength / 2 != getNumberBySearch(sortedArray[arrayLength / 2])) {
            popularElement = sortedArray[arrayLength / 2];
        }
        if (arrayLength * 3 / 4 != getNumberBySearch(sortedArray[arrayLength * 3 / 4])) {
            popularElement = sortedArray[arrayLength * 3 / 4];
        }
        return popularElement;
    }
}
