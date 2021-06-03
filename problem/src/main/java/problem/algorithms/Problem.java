package problem.algorithms;

import java.util.Arrays;

public class Problem {
    public boolean solve() {
        return true;
    }

    /**
     * @param a sorted array
     * @param b sorted array
     * @return a sorted array that contains all the elements from a and b
     */
    private static int[] merge(int[] a, int[] b) {

        if (a == null && b == null) {
            return null;
        } else if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        int totalSize = a.length + b.length;
        int[] c = new int[totalSize];

        int indexA = 0;
        int indexB = 0;
        int i = 0;
        while (indexA < a.length && indexB < b.length) {

            if (a[indexA] < b[indexB]) {
                c[i] = a[indexA];
                indexA++;
            } else {
                c[i] = b[indexB];
                indexB++;
            }

            i++;
        }

        while (indexA < a.length) {
            c[i] = a[indexA];
            indexA++;
            i++;
        }

        while (indexB < b.length) {
            c[i] = b[indexB];
            indexB++;
            i++;
        }

        return c;
    }

    /**
     * Given an array of integers in which all the numbers except one repeat twice,
     * find the non-repeating number in a single iteration.
     * 
     * @param a
     * @return
     */
    private static Integer findUnique(int[] a) {
        return Arrays.stream(a).reduce(0, (z, i) -> z ^ i);
    }

    public static void main(String... args) {
        int[] a = { 1, 10, 25, 31, 33, 50 };
        int[] b = { 2, 4, 32, 64 };
        int[] c = merge(a, b);
        System.out.println(Arrays.toString(c));

        System.out.println(findUnique(new int[] { 1, 2, 3, 2, 3 }));

        System.out.println(findUnique(new int[] { 150, 99, 87, 49, 31, 150, 87, 99, 49 }));

        System.out.println(findUnique(new int[] { 1, 2, 3, 4, 3, 4, 2, 1 }));
    }
}
