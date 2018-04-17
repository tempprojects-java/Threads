package com.gmail.gak.artem;

import java.math.BigInteger;

public class Factorial implements Runnable {
	private int threadNumber;

	public Factorial(int threadNumber) {
		super();
		this.threadNumber = threadNumber;
	}

	public Factorial() {
		super();
	}

	public BigInteger calc(int number) {
		BigInteger factorial = new BigInteger("1");

		for (int i = 1; i <= number; ++i) {
			factorial = factorial.multiply(new BigInteger("" + i));
		}

		return factorial;
	}

	@Override
	public void run() {
		System.out.println(this.threadNumber + "! = " + calc(this.threadNumber));
	}

	public int getThreadNumber() {
		return threadNumber;
	}

	public void setThreadNumber(int threadNumber) {
		this.threadNumber = threadNumber;
	}

}
