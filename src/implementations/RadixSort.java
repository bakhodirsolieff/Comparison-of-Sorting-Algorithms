package implementations;

import java.util.Arrays;

public class RadixSort{
    public static void main(String[] args) {
        int[] array = {123, 456, 789, 321, 654, 987, 543, 876, 210};
        RadixSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void RadixSort(int[] arr){
        for(int exp = 1; exp>0;exp *=10){
            count(arr,exp);
        }
    }
    public static void count(int[] arr,int exponent){
        int[] count = new int[10];
        int[] output = new int[arr.length];
        for(int i = 0;i < arr.length;i++) {
            count[(arr[i] / exponent) % 10]++;
        }
        for(int i = 1; i < 10;i++){
            count[i] += count[i-1];
        }
        for(int i = arr.length - 1;i>=0;i--){
            output[count[(arr[i]/exponent)%10]-1] = arr[i];
            count[(arr[i] / exponent)%10]--;
        }
        for(int i = 0; i < arr.length;i++){
            arr[i] = output[i];
        }
    }
}
