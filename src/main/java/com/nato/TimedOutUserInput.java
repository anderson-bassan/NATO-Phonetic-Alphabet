package com.nato;


import java.util.concurrent.*;
import java.io.BufferedReader;
import java.io.IOException;

public class TimedOutUserInput implements Runnable {
	private final GuessTheNatoWordViewer viewer;

	public TimedOutUserInput(GuessTheNatoWordViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);


			viewer.setTimeOverPanel();
			viewer.showTimeOverPanel();

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}