package com.gmail.gak.artem;

public class Sort implements Runnable {

	private int[] array;
	private int start;
	private int end;
	private Thread thread;

	public Sort(int[] array, int start, int end) {
		super();
		this.array = array;
		this.start = start;
		this.end = end;
		this.thread = new Thread(this);
		thread.start();
	}

	public Sort() {
		super();
	}

	@Override
	public void run() {

		for (int i = start; i < array.length - 1; i = i + end) {
			for (int j = Math.min(i + end, array.length - 1); j - end >= 0; j = j - end) {
				if (array[j - end] > array[j]) {
					int buffer = array[j];
					array[j] = array[j - end];
					array[j - end] = buffer;
				} else {
					break;
				}
			}
		}
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

}
