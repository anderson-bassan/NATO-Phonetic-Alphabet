package com.nato;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.IOException;

public class TimedOutUserInput {
	/* tries to get user input, but if they take too long return custom value */
	
	private final InputReader INPUT_READER;

	private final int TIME_OUT;
	private final TimeUnit TIME_OUT_UNIT;

	private final String EXIT_VALUE;
	private final String TIME_OUT_VALUE;
	
	public TimedOutUserInput(InputReader inputReader, int timeOut, TimeUnit timeOutUnit, String exitValue, String timeOutValue) {
		this.INPUT_READER = inputReader;
		this.TIME_OUT = timeOut;
		this.TIME_OUT_UNIT = timeOutUnit;
		this.EXIT_VALUE = exitValue;
		this.TIME_OUT_VALUE = timeOutValue;
	}
	
	public String getTimedOutUserInput() throws IOException {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		// input run's in a separated thread so it won't block the main thread after timing out
		Future<String> result = executor.submit(INPUT_READER);
		
		try {
			return result.get(TIME_OUT, TIME_OUT_UNIT);
			
		} catch(ExecutionException | InterruptedException e) {
			return EXIT_VALUE;
			
		} catch(TimeoutException e) {
			return TIME_OUT_VALUE; 
			
		} finally {
			executor.shutdown();
			
		}
	}
	
	public int getTimeOutValue() {
		return TIME_OUT;
	}
}