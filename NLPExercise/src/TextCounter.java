import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCounter {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/Users/nicholasperry/Desktop/sampletext.txt");
		Scanner scanner = new Scanner(file);
		
		ArrayList<String> paragraphs = new ArrayList<String>();
		
		while (scanner.hasNextLine()) {
			paragraphs.add(scanner.nextLine());
		}
		scanner.close();
		
		String entireText = ""; 

		for (String paragraph : paragraphs) {
			entireText = entireText + paragraph.toString() + " ";
		}
		
		Pattern pattern = Pattern.compile("[a-zA-Z]*[\\.\\-][\\\"]?[\\s]");
		Matcher matcher = pattern.matcher(entireText);
		
		int sentences = 0;
		while (matcher.find()) {
			sentences++;
		}
		
		System.out.println("This is an input test test run\n\n\nThere are " + paragraphs.size() + " paragraphs.");
		System.out.println("There are " + sentences + " sentences.");
		//Think about including other punctuation.
		System.out.println("There are " + entireText.split("\\s").length + " words.");
		//However, words here are defined as anything between the whitespace. Refine.

	}

}
