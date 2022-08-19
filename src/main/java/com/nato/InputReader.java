package com.nato;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.Callable;


public class InputReader implements Callable<String> {
	private BufferedReader bf;
	
	public InputReader(BufferedReader bf) {
		this.bf = bf;	
	}
	
	@Override
	public String call() {	
		try {
			// I could implement the following code in case the user takes too long to answer:
			/*

			while (!bf.ready()) {
				Thread.sleep();
			}
			String input = bf.readLine();
			
			In that case, the System.in wouldn't block the thread, but then the user wouldn't see what they're typing, so I 
			opted to instead print that they lost due to time, show the final result and end the whole program. Though, the
			cursor keeps blinking 'till the end of the code. It won't be needed when I implement non-blocking input with a GUI.
			*/
			
			String input = bf.readLine();
			return input;
		
		} catch (IOException e) {
			return "exit";
		}
	}
}