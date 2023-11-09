package implementations;

import java.util.Arrays;

public class HybridSort {
    public static void main(String[] args) {
        int[] array = {3,23,40,12,60,50,21,37,0,4,1,1,34,26};
        hybridSort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public static void hybridSort(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 <= 25) {
                insertionSort(arr, low, high);
            } else {
                int pivot = partition(arr, low, high);
                hybridSort(arr, low, pivot - 1);
                hybridSort(arr, pivot + 1, high);
            }
        }
    }
    public static void insertionSort(int[] arr, int low,int high) {
        for (int i = low+1; i <= high; i++) {
            int k = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low + (high - low) / 2];
        int left = low;
        int right = high;

        while (left <= right) {
            while (arr[left] < pivot)
                left++;
            while (arr[right] > pivot)
                right--;
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left-1;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
