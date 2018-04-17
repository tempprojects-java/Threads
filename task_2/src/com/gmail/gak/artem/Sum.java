package com.gmail.gak.artem;

public class Sum implements Runnable {

	private int[] array;
	private int start;
	private int end;
	private int sum;
	private Thread thread;
	private boolean stop = false;

	public Sum(int[] array, int start, int end) {
		super();
		this.array = array;
		this.start = start;
		this.end = end;
		this.thread = new Thread(this);
		thread.start();
	}

	public Sum() {
		super();
	}

	@Override
	public void run() {
		for (int i = start; i < end; ++i) {
			this.sum += array[i];
		}

		stop = true;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
