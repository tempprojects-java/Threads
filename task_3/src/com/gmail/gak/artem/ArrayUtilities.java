package com.gmail.gak.artem;

public class ArrayUtilities {

	public ArrayUtilities() {
		super();
	}

	public static int simpleSum(int[] array) {
		int result = 0;

		for (int i = 0; i < array.length; ++i) {
			result += array[i];
		}

		return result;
	}

	public static void sortByShellMethod(int[] array) {
		int i = array.length / 2;

		try {
			for (; i >= 1;) {
				Sort[] threads = new Sort[i];
				for (int start = 0; start < i; start++) {
					threads[start] = new Sort(array, start, i);
					threads[start].getThread().join();
				}
				i = i / 2;
			}
		} catch (InterruptedException e) {
			e.getStackTrace();
		}
	}

}
