package threesum;

import java.util.Scanner;

public class threeSumBruteForce {
	public static int count(int[] a) {
		int n = a.length;
		int count =0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1; k < n; k++) {
					if(a[i] + a[j] + a[k] == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("give array length");
		int len = sc.nextInt();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(count(arr));
	}
}
