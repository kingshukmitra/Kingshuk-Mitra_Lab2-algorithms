package transactions;

import java.util.Scanner;

public class PayMoney {

	// Method to check if target is achieved
	public static void TargetChecker(int targetToCheck, long arr[]) {

		int size = arr.length;
		Scanner sc1 = new Scanner(System.in);

		while (targetToCheck-- != 0) {

			boolean flag = true;
			long sum = 0;
			long target;

			System.out.println("Enter the value of target:");
			target = sc1.nextLong();

			for (int i = 0; i < size; i++) {

				sum += arr[i];

				if (sum >= target) {
					System.out.println("Target achieved after " + (i + 1) + " transactions");
					flag = false;
					break;
				}

				if (flag == true) {
					System.out.println("Target not achieved");
				}
			}

		}

		sc1.close();

	}

	// Driver method to take transaction inputs
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of the transaction array:");
		int size = sc.nextInt();

		long arr[] = new long[size];

		System.out.println("Enter the values of array:");

		for (int i = 0; i < size; i++)
			arr[i] = sc.nextLong();

		System.out.println("Enter the total no of targets that needs to be achieved:");

		int targetToCheck = sc.nextInt();

		PayMoney.TargetChecker(targetToCheck, arr);

		sc.close();

	}
}
