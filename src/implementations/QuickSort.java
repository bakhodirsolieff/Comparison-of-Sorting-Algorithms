package implementations;

import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] arr,int low,int high) {
        if (low >= high)
            return arr;
        if (arr.length < 2) {
            return arr;
        }
        if(arr.length != 0){
            int left = low;
            int right = high;
            int pivot = arr[low+(high-low)/2];
            while(left <= right){
                while(arr[left]<pivot)
                    left++;
                while(arr[right]>pivot)
                    right--;
                if(left <= right){
                    swap(arr,left,right);
                    left++;
                    right--;
                }
            }
            if(low < right)
                quickSort(arr,low,right);
            if(left < high)
                quickSort(arr,left,high);
        }
        return arr;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {36,21,24,56,44,15,89,12,32,2};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}