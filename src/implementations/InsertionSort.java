package implementations;

import java.util.Arrays;

public class InsertionSort{
    public static void main(String[] args) {
        int[] array = {9,7,3,2,1,5,4,6,8,0};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
        }
    }
}