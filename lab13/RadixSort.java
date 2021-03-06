/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort

    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        //how to compare the last digit? use array index? arr[ascii num] = ascii string
        int n = asciis.length;
        int R = 256; //extend ASCII alphabet size
        String[] aux = new String[n];

        //compute frequency counts
        int[] count = new int[R+1];
        for (int i = 0; i < n; i++){
            count[asciis[i].charAt(index) + 1]++;
        }

        //compute cumulates: key part
        for (int r = 0; r < R; r++){
            count[r+1] += count[r];
        }

        //move data
        for (int i = 0; i < n; i++){
            aux[count[asciis[i].charAt(index)]++] = asciis[i];
        }

        //copy back
        for (int i = 0; i < n; i++){
            asciis[i] = aux[i];
        }


    }

    public static String[] sortMSD(String[] asciis) {
        //Todo: implement MSD Sort
        return null;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }


  @Test
  public void testLSDSort(){
        String[] simpleTest1 = {"apple", "orange", "banana"};
        String[] sorted1 = {"banana", "apple", "orange"};
        assertArrayEquals(sorted1, RadixSort.sort(simpleTest1));
  }








}
