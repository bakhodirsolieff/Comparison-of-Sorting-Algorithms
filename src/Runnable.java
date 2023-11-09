import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Arrays;
public class Runnable {

    public static void main(String[] args) {
        int maxSize = 1000;//500 for smalldata.txt // 10000 for data.txt
        int sizeStep = 40;//50 for smalldata.txt  // 800 for data.txt
        int maxTimes = 1000; //1000for small data.txt // 1000 for data.txt
        try (FileWriter output = new FileWriter("SmallDataWithHybrid.txt")) {
            output.write("Array Size,Insertion Sort,Quick Sort,Hybrid Sort\n");
            for (int size = 10; size <= maxSize; size += sizeStep) {
                long totalInsertionSortTime = 0;
                long totalQuickSortTime = 0;
                long totalHybridSortTime = 0;
                //long totalHeapSortTime = 0;
                //long totalRadixSortTime = 0;

                for (int times = 0; times < maxTimes; ++times) {
                    int[] array = new int[size];

                    Random rand = new Random();
                    for (int i = 0; i < size; ++i) {
                        array[i] = rand.nextInt(maxSize + 1);
                    }
                    int[] quickSortArray = array.clone();
                    int[] hybridSortArray = array.clone();
                    //int[] heapSortArray = array.clone();
                    //int[] radixSortArray = array.clone();


                    long startTime = System.nanoTime();
                    insertionSort(array);
                    long endTime = System.nanoTime();
                    totalInsertionSortTime += endTime - startTime;


                    startTime = System.nanoTime();
                    quickSort(quickSortArray, 0, quickSortArray.length - 1);
                    endTime = System.nanoTime();
                    totalQuickSortTime += endTime - startTime;

                    startTime = System.nanoTime();
                    hybridSort(hybridSortArray,0,hybridSortArray.length-1);
                    endTime = System.nanoTime();
                    totalHybridSortTime += endTime - startTime;

                    /*startTime = System.nanoTime();
                    heapSort(heapSortArray);
                    endTime = System.nanoTime();
                    totalHeapSortTime += endTime - startTime;*/
                    /* startTime = System.nanoTime();
                    radixSort(radixSortArray);
                    endTime = System.nanoTime();
                    totalRadixSortTime += endTime - startTime;*/
                }


                long avgInsertionSortTime = totalInsertionSortTime / maxTimes;
                long avgQuickSortTime = totalQuickSortTime / maxTimes;
                long avgHybridSortTime = totalHybridSortTime / maxTimes;
               // long avgHeapSortTime = totalHeapSortTime / maxTimes;
                //long avgRadixSortTime = totalRadixSortTime / maxTimes;
                output.write(size + "," + avgInsertionSortTime + "," + avgQuickSortTime + "," + avgHybridSortTime  + "\n");
               // output.write(size + "," + avgInsertionSortTime + "," + avgQuickSortTime + "," + avgHeapSortTime + "," + avgRadixSortTime + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static int[] quickSort(int[] arr, int low, int high) {
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
    public static void hybridSort(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low + 1 <= 450) {
                insertionSort(arr, low, high);
            } else {
                int pivot = partition(arr, low, high);
                hybridSort(arr, low, pivot - 1);
                hybridSort(arr, pivot + 1, high);
            }
        }
    }
    public static int partition(int[] arr, int low, int high) {
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
    public static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int k = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  /*  public static void heapSort(int[] arr) {
        for(int i = arr.length / 2 - 1;i >= 0; i--)
            Heapify(arr,arr.length,i);
        for(int i = arr.length-1;i>=0;i--){
            int x = arr[0];
            arr[0] = arr[i];
            arr[i] = x;
            Heapify(arr,i,0);
        }
    }public static void Heapify(int[] arr,int HeapSize,int i){
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

    public static void radixSort(int[] arr) {
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
    }*/
}
