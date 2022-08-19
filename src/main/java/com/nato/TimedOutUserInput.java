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
	
	InputReader inputReader;
	
	public TimedOutUserInput(InputReader inputReader) {
		this.inputReader = inputReader;
	}
	
	public String getTimedOutUserInput(final int TIME_OUT, final TimeUnit UNIT, final String TIME_OUT_MESSAGE, final String EXCEPTION_RETURN_VALUE) throws IOException {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		// input run's in a separated thread so it won't block the main thread after timing out
		Future<String> result = executor.submit(inputReader);
		
		try {
			return result.get(TIME_OUT, UNIT);
			
		} catch(ExecutionException | InterruptedException e) {
			return EXCEPTION_RETURN_VALUE;
			
		} catch(TimeoutException e) {
			System.out.printf("%n%n%s%n", TIME_OUT_MESSAGE);
			return EXCEPTION_RETURN_VALUE; 
			
		} finally {
			executor.shutdown();
			
		}		
	}
}