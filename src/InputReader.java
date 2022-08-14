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
			String input = bf.readLine();
			return input;
		
		} catch (IOException e) {
			return "exit";
		}
	}
}