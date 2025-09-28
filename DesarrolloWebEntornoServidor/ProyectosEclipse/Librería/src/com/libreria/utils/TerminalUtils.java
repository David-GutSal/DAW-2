package com.libreria.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TerminalUtils {
	private static Scanner sc = new Scanner(System.in);
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	
	public static String inputText() {
		String result = sc.nextLine();
		return result;
	}
	
	public static void output(String text) {
		System.out.println(text);
	}

	public static int inputInt() {
		int result = Integer.parseInt(sc.nextLine());
		return result;
	}
	
	public static float inputFloat() {
	    float result = Float.parseFloat(sc.nextLine());
	    return result;
	}
	
	public static Double inputDouble() {
		double num = Double.parseDouble(sc.nextLine());
		return num;
	}
	
	public static Date inputDate(String date) throws ParseException {
		return formatter.parse(date);
	}
}
