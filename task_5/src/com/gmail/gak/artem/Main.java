package com.gmail.gak.artem;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File path = new File("./");
	    
	    Thread thread = new Thread(new FileWatcher(path));
	    thread.start(); 

	    System.out.println("---- Watcher Start ----");
	}
}
