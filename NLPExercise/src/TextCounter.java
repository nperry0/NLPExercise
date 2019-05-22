import java.io.*;
import java.util.*;


public class TextCounter {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/Users/nicholasperry/Desktop/sampletext.txt");
		Scanner scanner = new Scanner(file);
		
		ArrayList<String> paragraphs = new ArrayList<String>();
		
		while (scanner.hasNextLine()) {
			//String inputText = scanner.nextLine();
			paragraphs.add(scanner.nextLine());
		}
		//String inputText = scanner.nextLine();
		scanner.close();
		
		System.out.println("This is an input test test run\n\n\nThere are " + paragraphs.size() + " paragraphs.");
	}

}