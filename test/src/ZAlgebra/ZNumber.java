package ZAlgebra;

import java.util.ArrayList;
import java.util.Arrays;

//import java.util.Scanner;
public final class ZNumber {

	private String zStr;

	public ZNumber(char[] digits) {
		StringBuilder sb = new StringBuilder();
		for (char value : digits) {
			ZDigit zd = new ZDigit(value);
			sb.append(zd);
		}
		this.zStr = sb.toString();
	}

	public ZNumber(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			ZDigit zd = new ZDigit(s.charAt(i));
			sb.append(zd);
		}
		this.zStr = sb.toString();
	}

	public ZNumber(ArrayList<Character> li) {
		StringBuilder sb = new StringBuilder();
		for (Character value : li) {
			ZDigit zd = new ZDigit(value);
			sb.append(zd);
		}
		this.zStr = sb.toString();
	}

	@Override
	public String toString() {
		return zStr;
	}

	public String toDecimal() {

		int value = 0;
		ZDigit[] digits = getDigits();
//		for (int i = 0; i < digits.length; i++) {
		for(ZDigit digit: digits){
//		ZDigit digit = digits[i];
			value = 27 * value + digit.getValue();
		}
		this.zStr = Integer.toString(value);
		return zStr;
	}

	public ZDigit[] getDigits() {
		ZDigit[] zd = new ZDigit[zStr.length()];
		for (int i = 0; i < zStr.length(); i++) {
			zd[i] = new ZDigit(zStr.charAt(i));
		}
		return zd;
	}

	public static void main(String[] args) {
		ZNumber zn = new ZNumber(new char[] { 'A', 'B', 'C' });
		// zn = new ZNumber("ABC".toCharArray());
		System.out.println(zn);
		zn.toDecimal();
		System.out.println("Decimal value of ZNumber is " + zn.zStr);

		ZNumber zn1 = new ZNumber("ABCDE");
		System.out.println(zn1);

		// ArrayList<Character> li = new ArrayList<Character>();
		ArrayList<Character> li = new ArrayList<Character>(Arrays.asList('D','E'));
		// li.add('D');
		// li.add('E');
		System.out.println(li);

		ZNumber zn2 = new ZNumber(li);
		System.out.println(zn2);

		ZDigit[] zd = zn2.getDigits();
		System.out.print("Zdigits are ");
		for (ZDigit digit : zd) {
			System.out.print(digit.getZDigit() + " ");
		}

	}
}