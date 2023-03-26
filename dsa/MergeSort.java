package dsa;

import java.util.Scanner;

public class MergeSort {
	
	//printArray
	public static void printArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void mergeSort(int arr[] , int si, int ei) {
		
		if(si>=ei) {
			return;
		}
		
		int mid = si +(ei-si)/2; // (si+ei)/2
		mergeSort(arr,si,mid);
		mergeSort(arr,mid+1,ei);
		merge(arr,si,mid,ei);
	}
	
	public static void merge(int arr[] , int si, int mid, int ei) {
		int temp[] = new int[ei-si+1];
		int i = si; //iterator for left part
		int j = mid+1; //iterator for right part
		int k = 0; //iterator for temp array
		
		while(i<=mid && j<=ei) {
			if(arr[i] < arr[j] ) {
				temp[k] = arr[i];
				i++;
			}else {
				temp[k] = arr[j];
				j++;
			}k++;
		}
		
		while(i<=mid) {
			temp[k++] = arr[i++];
		}
		
		while(j<=ei) {
			temp[k++] = arr[j++];
		}
		
		for(k=0,i=si;k<temp.length;k++,i++) {
			arr[i] = temp[k];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("number of elements you want to insert");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Insert elements now :");
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(arr,0,arr.length-1);
		System.out.println("Elements in sorted format :");
		printArray(arr);
		
	}

}
