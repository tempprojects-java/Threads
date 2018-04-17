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

	public static int sum(int[] array) {

		int processors = Runtime.getRuntime().availableProcessors();
		int breakpoint = (int) Math.ceil((double) array.length / processors);
		Sum[] threads = new Sum[processors];

		try {
			for (int i = 0; i < threads.length; ++i) {
				int start = i * breakpoint;
				int end = start + breakpoint;
				if (end > array.length) {
					end = array.length;
				}
				threads[i] = new Sum(array, start, end);
				threads[i].getThread().join();
			}
		} catch (InterruptedException e) {
			e.getStackTrace();
		}

		int result = 0;
		for (int i = 0; i < threads.length; ++i) {
			result += threads[i].getSum();
		}

		return result;
	}

}
