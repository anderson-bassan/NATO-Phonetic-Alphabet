// imports for handling user input
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// imports to create callable
import java.util.concurrent.Callable;

public class InputReader implements Callable<String> {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public String call() {
		try {
			// I could implement the following code in case the user takes too long to answer:
			/*
			while (!bf.ready()) {
				Thread.sleep();
			}
			String input = bf.readLine();
			
			In that case the System.in wouldn't block the thread, but then the user wouldn't see they're typing, so I opted for printing
			that they lost due to time, and the final result, and end the whole program, even though the cursor keeps blinking 'till the
			end of the code for better usability. It won't be needed when I implement the GUI or if I use the NIO to implement non-blocking
			input reading though.
			*/
			
			String input = bf.readLine();
			return input;
		
		} catch (IOException e) {
			return "exit";
		}
	}
}