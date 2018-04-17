package com.gmail.gak.artem;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		long tstart;
		long tend;
		int size = 199999999;
		int[] array = randomIntArray(size);
	
		System.out.println("------  Thread x processors  -----");
		
		tstart = System.currentTimeMillis();
		System.out.println("sum = " + ArrayUtilities.sum(array));
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms");

		System.out.println("------  IntStream -----");
		
		tstart = System.currentTimeMillis();
		System.out.println("sum = " + IntStream.of(array).sum());
		tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms");
		
		System.out.println("------  Simple  -----");
		
		tstart = System.currentTimeMillis();
		System.out.println("sum = " + ArrayUtilities.simpleSum(array));
		tend = System.currentTimeMillis();
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
