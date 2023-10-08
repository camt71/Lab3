package lab3;

import java.util.Arrays;
import java.util.Collections;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

//task 1.1
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				return i;
		}
		return -1;
	}

	public int recuriveLinearSearch(int target) {
		return recuriveLinearSearchHelp(array.length, target);
	}

	public int recuriveLinearSearchHelp(int size, int target) {
		if (size == 0)
			return -1;
		if (array[size - 1] == target)
			return size - 1;
		return recuriveLinearSearchHelp(size - 1, target);
	}

	// task 1.2
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid])
				return mid;
			else if (target < array[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}

		return -1;
	}

	public int recursiveBinarySearch(int size, int target, int low, int high) {
		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (target == array[mid])
				return mid;
			else if (target < array[mid])
				return recursiveBinarySearch(array.length, target, low, mid - 1);
			else
				return recursiveBinarySearch(array.length, target, mid + 1, high);
		}
	}

	public int[] sortDescending() {
		Arrays.sort(array);//sap xep mang theo chieu tang dan
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");//in mang theo chieu giam dan
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		MyArray myArray = new MyArray(array);
//		System.out.println(myArray.iterativeLinearSearch(45));
//		System.out.println(myArray.recuriveLinearSearch(45));
//		System.out.println(myArray.iterativeBinarySearch(45));
//		System.out.println(myArray.recursiveBinarySearch(8, 10, 3, 7));
		myArray.sortDescending();
	}
}
