/**
 * File Name: AddingNumbers.java<br>
 * Chillappagari, Srikanth<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Oct 10, 2016
 */
package com.sqa.sc;

import com.sqa.sc.helpers.*;

/**
 * AddingNumbers //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Chillappagari, Srikanth
 * @version 1.0.0
 * @since 1.0
 */
public class AddingNumbers {

	private static String appName = "Adding Numbers";

	private static int numberCount;

	private static String userName;

	public static int addNumbers(int... num) {
		int total = 0;
		for (int i = 0; i < num.length; i++) {
			total += num[i];
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(" Hello and Welcome to the " + appName + "Application");
		userName = RequestInput.getString("Could I get your name ");
		numberCount = RequestInput.getInt(" how many numbers would you like to add together");
		int[] numbers = new int[numberCount];
		for (int i = 0; i < numberCount; i++) {
			numbers[i] = RequestInput.getInt("could I get number value" + (i + 1) + ":");
		}
		System.out.println(" total of adding  is " + addNumbers(numbers));
		System.out.println(" Thank you " + userName + ", for using the" + appName + "Application.");
	}
}
