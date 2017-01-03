package threesum;

import java.util.Arrays;
import java.util.Scanner;

public class threeSumBinarySearch {
	public static int binarySearch(int[] a, int key, int low) {
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low)/2;
			if (key > a[mid]) low = mid + 1;
			else if (key < a[mid]) high = mid - 1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[];
		int count = 0;
		System.out.println("give array size");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		arr = new int[size];
		System.out.println("give elements in array");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int low = j + 1;
				if (binarySearch(arr, -(arr[i] + arr[j]),low) != -1) {
					count++;
				} 
			}
		}
		System.out.println(count);
	}
}
