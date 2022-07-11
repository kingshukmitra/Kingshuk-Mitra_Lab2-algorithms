package Denominations;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the size of currency denominations ");
		int size = sc.nextInt();
		int[] denominations = new int[size];
		
		System.out.println("Please enter the currency denominations value");
		for (int i = 0; i < size; i++) {
			denominations[i] = sc.nextInt();
		}
		System.out.println("Please enter the amount you want to pay");
		int amount = sc.nextInt();
		
		MinNoteCounter mnc = new MinNoteCounter();
		
		mnc.countMyNotes(denominations,amount);
		
		sc.close();

	}

}
