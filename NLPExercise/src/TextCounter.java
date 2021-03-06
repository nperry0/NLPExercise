import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCounter {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
				
		String text = fileToString(file);

		int words = countWords(text);
		int sentences = countSentences(text);
		int paragraphs = countParagraphs(text);
		
		System.out.println("There are " + words + " words.");	
		System.out.println("There are " + sentences + " sentences.");	
		System.out.println("There are " + paragraphs + " paragraphs.");
		
	}
	
	public static String fileToString(File file) throws FileNotFoundException {
		String text = "";
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			text = text + scanner.nextLine() + "\n";
		}
		scanner.close();
		return text;
	}
	
	public static int countWords(String text) {
		int words = 0;
		Pattern pattern = Pattern.compile("(([A-Z]{1}\\.{1}){2,})|([a-zA-Z]+[-']?[a-zA-Z]+|[Ia])");
		//Pattern pattern = Pattern.compile("[[A-Z]{1}[\\.]{1}]{2,}"); // For acronyms
		//Pattern pattern = Pattern.compile("[a-zA-Z]+[-']?[a-z]+|[Ia]"); // For all other normal words

		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			words++;
		}
		return words;
	}
	
	public static int countSentences(String text) {
		int sentences = 0;
		Pattern pattern = Pattern.compile("\\w*[\\.\\-!\\?]+\"?\\s");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			sentences++;
		}
		return sentences;
	}

	public static int countParagraphs(String text) {
		int paragraphs = 0;
		Pattern pattern = Pattern.compile("\n");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			paragraphs++;
		}
		return paragraphs;
	}
}
