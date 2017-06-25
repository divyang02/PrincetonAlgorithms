package sets;

import java.util.Scanner;

public class WhiteList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new Set<String>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			set.add(sc.nextLine());
		}
		while(sc.hasNextLine()) {
			String word = sc.nextLine();
			if(set.contains(word)) System.out.println(word);
		}
	}

}
