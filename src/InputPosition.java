
public class InputPosition {
	public static int position(char c) {
		return (int)c - (int)'a';
	}

	public static char characterFor(int i) {
		return (char) ((int) 'a' + i);
	}
}
