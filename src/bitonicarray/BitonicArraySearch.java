package bitonicarray;

import java.util.Scanner;

public class BitonicArraySearch {
	public static int binarySearch(int[] a, int key, int low, int high) {
			while (low <= high) {
				int mid = low + (high - low)/2;
				if (key > a[mid]) low = mid + 1;
				else if (key < a[mid]) high = mid - 1;
				else return mid;
			}
		return -1;
	}
	
	public static int decBinarySearch(int[] a, int key, int low, int high) {
		while (low >= high) {
			int mid = high + (low - high)/2;
			if (key < a[mid]) high = mid + 1;
			else if (key > a[mid]) low = mid - 1;
			else return mid;
		}
	return -1;
	}
	
	private static int findMidBinary(int[] a) {
		int low = 0, high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
				return mid;
			} else if (a[mid] > a[mid - 1] && a[mid + 1] > a[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println("enter a bitonic array of size 3");
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("enter key to be searched");
		int key = sc.nextInt();
		int returnVal = binarySearch(arr,key,0,findMidBinary(arr));
		
		if(returnVal == -1) {
			returnVal = decBinarySearch(arr,key,arr.length - 1,findMidBinary(arr) + 1);
			
			if(returnVal == -1) {
				System.out.println("the key is not there");
			} else {
				System.out.println("no is there");
			}
			
		} else {
			System.out.println("the no is there");
		}
	}
}
