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
	int timeOut;
	TimeUnit timeOutUnit;
	String timeOutMessage;
	String exitValue;
	
	public TimedOutUserInput(InputReader inputReader, int timeOut, TimeUnit timeOutUnit, String timeOutMessage, String exitValue) {
		this.inputReader = inputReader;
		this.timeOut = timeOut;
		this.timeOutUnit = timeOutUnit;
		this.timeOutMessage = timeOutMessage;
		this.exitValue = exitValue;
	}
	
	public String getTimedOutUserInput() throws IOException {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		// input run's in a separated thread so it won't block the main thread after timing out
		Future<String> result = executor.submit(inputReader);
		
		try {
			return result.get(timeOut, timeOutUnit);
			
		} catch(ExecutionException | InterruptedException e) {
			return exitValue;
			
		} catch(TimeoutException e) {
			System.out.printf("%n%n%s%n", timeOutMessage);
			return exitValue; 
			
		} finally {
			executor.shutdown();
			
		}		
	}
}