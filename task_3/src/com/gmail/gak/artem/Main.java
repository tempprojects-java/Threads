package com.gmail.gak.artem;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		int size = 14;
		int[] array = randomIntArray(size);
		long tstart;
		long tend;

		System.out.println("------  Array  -----\n");

		System.out.println(Arrays.toString(array));

		System.out.println("------  Sort by Shell  -----\n");

		tstart = System.currentTimeMillis();
		ArrayUtilities.sortByShellMethod(array);
		tend = System.currentTimeMillis();

		System.out.println(Arrays.toString(array) + "\n");

		System.out.println((tend - tstart) + " ms");
	}

	public static int[] randomIntArray(int size) {
		int[] result = new int[size];

		for (int i = 0; i < result.length; ++i) {
			result[i] = randomInt();
		}

		return result;
	}

	public static int randomInt() {
		return ThreadLocalRandom.current().nextInt(1, 100 + 1);
	}

}
