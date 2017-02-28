package com.levent.sercedb.cli;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		Command command;
		Mode mode = Mode.CLI;
		ModeHandler handler = new ModeHandlerImpl();
		boolean shouldQuit = false;
		
		System.out.println("Welcome to SerceDB Beta");
		System.out.println("***********************");
		
		while(!shouldQuit) {
			switch(mode) {
				case CLI: {
					System.out.printf(">");
					input = scanner.nextLine();
					input = input.toLowerCase();	// all letters must be lower-case
					input = input.trim();			// no leading/trailing whitespace
					
					command = mapCommands(input);
					mode = handler.handleCLI(command);	
					
					break;
				}
				
				case SQL: {
					System.out.printf(">");
					input = scanner.nextLine();
					input = input.toLowerCase();	// all letters must be lower-case
					input = input.trim();			// no leading/trailing whitespace
					
					mode = handler.handleSQL(input);
					
					break;
				}
				
				case EXIT: {
					shouldQuit = true;
					break;
				}
			}
			
		}
		
		scanner.close();
	}
	
	/*
	 * For future use, input string is mapped to Enumeration
	 */
	private static Command mapCommands(String input) {		
		Command command;
		
		switch(input) {
			case "quit": {
				command = Command.QUIT;
				break;
			}
			
			case "sql": {
				command = Command.SQL;
				break;
			}
			
			case "help": {
				command = Command.HELP;
				break;
			}
			
			case "": {
				command = Command.NO_COMMAND;
				break;
			}
			
			default: {
				command = Command.NO_COMMAND;
			}
		}
		
		return command;
	}

}
