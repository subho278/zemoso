package ZAlgebra;

//import java.util.Scanner;

public final class ZDigit {

	private char character;

	public ZDigit(char c) {
		String s = Character.toString(c);
		if (s.matches("[A-Z0]")) {
			this.character = c;
		} else {
			throw new IllegalArgumentException("Entered value is not a ZDigit");
		}
	}

	public char getZDigit() {
		return character;
	}

	public int getValue() {

		String base = new String();
		base = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		int value = base.indexOf(character);
		return value;

	}

	public String toString() {
		// return ""+character;
		// return String.valueOf(character);
		return Character.toString(character);
	}

	public static void main(String[] args) {
		/*
		 * Scanner in = new Scanner(System.in);
		 * System.out.print("Enter a ZDigit: "); char c =
		 * in.next(".").charAt(0);
		 */
		ZDigit zd = new ZDigit('A');
		System.out.println("ZDigit is " + zd);
		System.out.println("Value of ZDigit is " + zd.getValue());
	}
}