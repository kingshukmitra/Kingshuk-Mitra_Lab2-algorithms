package Denominations;

public class MinNoteCounter {

	// Used for merge sort
	static void merge(int arr[], int left, int mid, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] >= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	// Sorts descending array[left...right] using merge()
	static void sort(int[] notes, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sort(notes, left, mid);
			sort(notes, mid + 1, right);

			// Merge the sorted halves
			merge(notes, left, mid, right);
		}
	}

	// Prints the minimum no. of notes for given denominations and an amount
	public void countMyNotes(int denominations[], int amount) {

		int[] noteCounter = new int[denominations.length];
		sort(denominations, 0, denominations.length - 1);

		// Catches exceptions where denomination is 0
		try {

			// Counts min no of notes required for each denomination
			for (int i = 0; i < denominations.length; i++) {
				if (amount >= denominations[i]) {
					noteCounter[i] = amount / denominations[i];
					amount = amount - noteCounter[i] * denominations[i];
				}
			}

			// If amount still has a value > 0, these denominations are not sufficient
			if (amount > 0) {
				System.out.println("Exact amount cannot be paid using these denominations");
			} else {
				System.out.println("Your payment approach in order to give min no of notes will be");
				for (int i = 0; i < denominations.length; i++) {
					if (noteCounter[i] != 0) {
						System.out.println(denominations[i] + ":" + noteCounter[i]);
					}
				}
			}
		} catch (ArithmeticException e) {
			System.out.println("Error: " + e + " | Notes of denomination 0 are invalid");
		}
	}

}
