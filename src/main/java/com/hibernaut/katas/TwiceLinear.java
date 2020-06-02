package com.hibernaut.katas;

import java.util.ArrayList;

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
        int x = 0;
        int y = 0;
        int nextX;
        int nextY;

        ArrayList<Integer> sequence = new ArrayList();

        sequence.add(0, 1);

        for (int i = 0; i < n; i++) {
            nextX = 2 * sequence.get(x) + 1;
            nextY = 3 * sequence.get(y) + 1;

            if (nextX <= nextY) {
                sequence.add(nextX);
                x++;
                if (nextX == nextY) {
                    y++;
                }
            } else {
                sequence.add(nextY);
                y++;
            }
        }

        return sequence.get(n);
    }
}
