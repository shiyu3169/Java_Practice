import java.util.Arrays;
import java.util.Random;

public class SortsLab {
	public static void main(String[] args) {

		// create the array with 20 slots
		int[] anArray;
		anArray = new int[20];

		// fill the array with random numbers
		Random rand = new Random();
		for (int i = 0; i < anArray.length; i++) {
			anArray[i] = rand.nextInt(100) + 51;
		}
		// print the original array
		System.out.println();
		System.out.println("The original array:");
		System.out.println(Arrays.toString(anArray));

		// selection sort the array
		selectionSort(anArray);

		// print the sorted array
		System.out.println("The selection sorted array:");
		System.out.println(Arrays.toString(anArray));

		// create and print a random number
		int key = rand.nextInt(100) + 1;
		System.out.println();
		System.out.println("The target number is " + key);

		// finding the target using binary search
		binarySearch(anArray, 0, anArray.length - 1, key);
		
		// create another array with 20 slots
		int[] anArray2;
		anArray2 = new int[20];

		// fill the 2nd array with random numbers
		for (int i = 0; i < anArray.length; i++) {
			anArray2[i] = rand.nextInt(100) + 51;
		}
		// print the 2nd array
		System.out.println();
		System.out.println("The original array:");
		System.out.println(Arrays.toString(anArray2));

		// insertion sort the array
		insertionSort(anArray2);

		// print the sorted 2nd array
		System.out.println("The insertion sorted array:");
		System.out.println(Arrays.toString(anArray2));

		// create and print another random number
		int key2 = rand.nextInt(100) + 1;
		System.out.println();
		System.out.println("The target number is " + key2);

		// finding the target using binary search
		binarySearch(anArray2, 0, anArray2.length - 1, key2);
	}

	// selection sort-------------------------------
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index])
					index = j;

			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
	}

	// insertion sort--------------------------------------------------
	public static void insertionSort(int array[]) {
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
	}

	// binary search--------------------------------------------------
	public static void binarySearch(int[] array, int lowerbound, int upperbound, int key) {
		int location;
		// counting the number of comparisons
		int iterate = 1;

		// find the subscript of the middle position.
		location = (lowerbound + upperbound) / 2;

		while ((array[location] != key) && (lowerbound <= upperbound)) {
			iterate++;
			// If the number is > key
			if (array[location] > key) {
				// check from middle to upperbound
				upperbound = location - 1;
			}
			// If the number is < key
			else {
				// check from lowerbound to middle
				lowerbound = location + 1;
			}
			location = (lowerbound + upperbound) / 2;
		}

		// output the result
		if (lowerbound <= upperbound) {
			System.out.println("The number was found in array at location " + location);
			System.out.println("The number of iterations required is " + iterate);
		} else {
			System.out.println("The number is not in this array");
		}
	}
}
