import java.util.Scanner;

public class Start {
	public static int ct;
	public static StringBuilder sb = new StringBuilder();
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Pig Latin Generator: ");
		start();
	}

	public static void start() {
		System.out.println("What word would you like to convert?");
		String line = sc.nextLine();
		sc.close();
		line = line.toLowerCase();
		String sub;
		int count = 0 + 1;
		int x = 0;
		for (char c : line.toCharArray()) {
			if (c == ' ') {
				count++;
			}
		}
		for (int i = 0; i < count; i++) {

			sub = line.substring(x);
			int y = sub.indexOf(" ");

			if (y > 0) {
				sub = sub.substring(0, y);
				pig(sub);
				x = x + y + 1;
			} else {
				pig(line.substring(x));
				print();
			}
		}

	}

	public static void pig(String line) {
		String vowels = "aeiouy";
		int y = 0;
		loop: for (int i = 0; i < line.length(); i++) {
			for (int x = 0; x < vowels.length(); x++) {
				if (vowels.charAt(x) == line.charAt(i)) {
					y = i;
					break loop;
				}
			}
		}

		String word = line.substring(y) + "-" + line.substring(0, y) + "ay";
		list(word);
	}

	public static void list(String word) {
		sb.append(word + " ");
	}

	public static void print() {
		String words = sb.toString();
		System.out.println(words);
	}
}
