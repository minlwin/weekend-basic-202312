package com.jdc.application;

import java.util.Scanner;

import com.jdc.application.ApplicationException.Type;

public class Inputs {

	private Scanner scanner;
	
	public Inputs() {
		scanner = new Scanner(System.in);
	}
	
	public String readString(String field) {
		System.out.print("Enter %s : ".formatted(field));
		var input = scanner.nextLine();
		
		// Blank String
		if(input.isBlank()) {
			throw new ApplicationException(Type.BLANK, field);
		}
		
		// Exit
		if("exit".equalsIgnoreCase(input) ) {
			throw new ApplicationException(Type.EXIT);
		}
		
		return input;
	}
	
	public int readInt(String field)  {
		try {
			var string = readString(field);
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new ApplicationException(Type.NAN, field);
		}
	}

	public String readString(String field, int tryCount) {
		
		var count = 0;
		
		while(count < tryCount) {
			count ++;
			
			System.out.print("Enter %s : ".formatted(field));
			var input = scanner.nextLine();
			
			// Exit
			if("exit".equalsIgnoreCase(input) ) {
				throw new ApplicationException(Type.EXIT);
			}
			
			if(input.isBlank()) {
				System.out.printf("Please enter %s.%n%n", field);
				continue;
			}
			
			return input;
		}
		
		throw new ApplicationException(Type.EXEED_MAX_MISSING_COUNT);
	}

	public int readInt(String field, int tryCount) {
		
		var count = 0;
		
		while(count < tryCount) {
			
			try {
				count ++;
				System.out.print("Enter %s : ".formatted(field));
				var input = scanner.nextLine();
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter valid %s.%n".formatted(field));
			}
		}

		throw new ApplicationException(Type.EXEED_MAX_MISSING_COUNT);
	}
	
}
