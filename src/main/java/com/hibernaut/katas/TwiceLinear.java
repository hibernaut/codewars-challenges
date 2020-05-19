package com.hibernaut.katas;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Consider a sequence u where u is defined as follows:
 * <p>
 * The number u(0) = 1 is the first one in u.
 * For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
 * There are no other numbers in u.
 * <p>
 * Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]
 * <p>
 * 1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and 22 and so on...
 * Task:
 * <p>
 * Given parameter n the function dbl_linear (or dblLinear...) returns the element u(n)
 * of the ordered (with <) sequence u (so, there are no duplicates).
 * Example:
 * <p>
 * dbl_linear(10) should return 22
 * Note:
 * <p>
 * Focus attention on efficiency
 */

public class TwiceLinear {
    public static int dblLinear(int n) {
        int elementId = 0;
        int initialElement;
        int secondElement;
        int thirdElement;
        ArrayList<Integer> sequence = new ArrayList();

        //Initializing starting element
        sequence.add(elementId, 1);

        while (elementId < n) {
            //Putting current element into variable container
            initialElement = sequence.get(elementId);

            //Calculating second element and if it does not repeat, adding to sequence
            secondElement = 2 * initialElement + 1;
            if (!sequence.contains(secondElement)) {
                sequence.add(secondElement);
            }

            //Calculating third element and if it does not repeat, adding to sequence
            thirdElement = 3 * initialElement + 1;
            if (!sequence.contains(thirdElement)) {
                sequence.add(thirdElement);
            }

            //Increasing element ID
            elementId++;

            //Sorting the sequence
            Collections.sort(sequence);
        }

        return sequence.get(elementId);
    }
}
