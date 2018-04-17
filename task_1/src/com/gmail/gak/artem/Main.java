package com.gmail.gak.artem;

public class Main {

	public static void main(String[] args) {

		int size = 100;

		Thread[] threads = new Thread[size];

		for (int i = 0; i < threads.length; ++i) {
			threads[i] = new Thread(new Factorial(i));
			threads[i].start();
		}

	}

}
