package dsa;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in the array (in ascending order):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the element to be searched: ");
        int x = scanner.nextInt();
        
        int result = binarySearch(arr, 0, n - 1, x);
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index " + result + " in the array.");
        }
        
        scanner.close();
}
	
	public static int binarySearch(int[] arr, int left, int right, int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, left, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, right, x);
        }
        return -1;
    }
}
