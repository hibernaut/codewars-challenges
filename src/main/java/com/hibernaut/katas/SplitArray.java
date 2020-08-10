package com.hibernaut.katas;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.ListIterator;

/**
 * You will receive an array as parameter that contains 1 or more integers and a number n.
 * <p>
 * Here is a little visualization of the process:
 * <p>
 * Step 1: Split the array in two:
 * <p>
 * [1, 2, 5, 7, 2, 3, 5, 7, 8]
 * /            \
 * [1, 2, 5, 7]    [2, 3, 5, 7, 8]
 * <p>
 * Step 2: Put the arrays on top of each other:
 * <p>
 * [1, 2, 5, 7]
 * [2, 3, 5, 7, 8]
 * <p>
 * Step 3: Add them together:
 * <p>
 * [2, 4, 7, 12, 15]
 * <p>
 * Repeat the above steps n times or until there is only one number left, and then return the array.
 * Example
 * <p>
 * Input: arr=[4, 2, 5, 3, 2, 5, 7], n=2
 * <p>
 * <p>
 * Round 1
 * -------
 * step 1: [4, 2, 5]  [3, 2, 5, 7]
 * <p>
 * step 2:    [4, 2, 5]
 * [3, 2, 5, 7]
 * <p>
 * step 3: [3, 6, 7, 12]
 * <p>
 * <p>
 * Round 2
 * -------
 * step 1: [3, 6]  [7, 12]
 * <p>
 * step 2:  [3,  6]
 * [7, 12]
 * <p>
 * step 3: [10, 18]
 * <p>
 * <p>
 * Result: [10, 18]
 */

public class SplitArray {
    public static int[] splitAndAdd(int[] numbers, int n) {
        //Converting simple array with priimitive types into ArrayList with Integer objects
        List<Integer> mainArray = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        //Creating two utility arrays
        List<Integer> firstArray = new ArrayList<>();
        List<Integer> secondArray = new ArrayList<>();

        //Initializing ListIterator variable
        ListIterator<Integer> iterator;

        //A loop with condition checking lefted value of iteration counter and array size
        while (n > 0 && mainArray.size() > 1) {

            //Creating ListIterator which helps split array in two
            iterator = mainArray.listIterator();

            //Splitting main array into two utility arrays
            while (iterator.hasNext()) {
                if (iterator.nextIndex() < (mainArray.size() / 2)) {
                    firstArray.add(iterator.next());
                } else {
                    secondArray.add(iterator.next());
                }
            }

            //Clearing main array
            mainArray.clear();

            //Adding first item of second array, if two utility arrays are not the same size
            //And removing this item from secondary array after this operation
            if (firstArray.size() != secondArray.size()) {
                mainArray.add(secondArray.get(0));
                secondArray.remove(0);
            }

            //Filling main array with sum of relevant elements of each utility array
            for (int i = 0; i < firstArray.size(); i++) {
                mainArray.add(firstArray.get(i) + secondArray.get(i));
            }

            //Clearing first and second utility arrays
            firstArray.clear();
            secondArray.clear();

            //Decreasing iteration counter
            --n;
        }

        //Returning final result, preliminarily converted to simple array with primitive data types
        return mainArray.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
