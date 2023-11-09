package implementations;
import java.util.Arrays;


public class HeapSort{
    public static void Sort(int arr[]){
        for(int i = arr.length / 2 - 1;i >= 0; i--)
            Heapify(arr,arr.length,i);
        for(int i = arr.length-1;i>=0;i--){
            int x = arr[0];
            arr[0] = arr[i];
            arr[i] = x;
            Heapify(arr,i,0);
        }
    }
    public static void Heapify(int[] arr,int HeapSize,int i){
        int largeNum = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < HeapSize && arr[left] > arr[largeNum]){
            largeNum = left;
        }
        if(right < HeapSize && arr[right] > arr[largeNum]){
            largeNum = right;
        }
        if(largeNum != i){
            int swap = arr[i];
            arr[i] = arr[largeNum];
            arr[largeNum] = swap;
            Heapify(arr,HeapSize,largeNum);
        }
    }
    public static void main(String[] args){
        int[] array = {23,1267,345,128,687,256,777};
        Sort(array);
        System.out.println(Arrays.toString(array));
    }
}
