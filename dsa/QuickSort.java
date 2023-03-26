package dsa;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    
//    public static void quickSort(int[] arr) {
//        quickSort(arr, 0, arr.length - 1);
//    }
    
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }
    
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("number of elements you want to insert");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Insert elements now :");
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
