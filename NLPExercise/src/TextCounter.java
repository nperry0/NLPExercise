import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCounter {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/Users/nicholasperry/Desktop/sampletext.txt");
		Scanner scanner = new Scanner(file);
		String text = "";
		while(scanner.hasNextLine()) {
			text = text + scanner.nextLine() + "\n";
		}
		scanner.close();

		int words = countWords(text);
		int sentences = countSentences(text);
		int paragraphs = countParagraphs(text);
		
		//However, words here are defined as anything between the whitespace. Refine.
		System.out.println("There are " + words + " words.");	
		//Think about including other punctuation.
		System.out.println("There are " + sentences + " sentences.");	
		//This only works if there is a new line at the end of last paragraph
		System.out.println("There are " + paragraphs + " paragraphs.");
		
	}
	
	public static int countWords(String text) {
		return text.split("\\s").length;
	}
	
	public static int countSentences(String text) {
		int sentences = 0;
		Pattern pattern = Pattern.compile("[a-zA-Z]*[\\.\\-][\\\"]?[\\s]");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			sentences++;
		}
		return sentences;
	}

	public static int countParagraphs(String text) {
		int paragraphs = 0;
		Pattern pattern = Pattern.compile("[\n]");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			paragraphs++;
		}
		return paragraphs;
	}
}
