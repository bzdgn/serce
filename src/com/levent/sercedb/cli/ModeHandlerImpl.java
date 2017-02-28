package com.levent.sercedb.cli;

import com.levent.sercedb.parser.Parser;

public class ModeHandlerImpl implements ModeHandler {

	@Override
	public Mode handleCLI(Command command) {
		Mode mode = Mode.CLI;
		
		switch(command) {
			case QUIT: {
				mode = Mode.EXIT;
				System.out.println("Exiting...");
				break;
			}
			
			case SQL: {
				System.out.println("Mode: SQL");
				mode = Mode.SQL;
				break;
			}
			
			case HELP: {
				System.out.printf("Commands;%n\t1- quit%n\t2- sql%n\t3- help%n");
				break;
			}
			
			case NO_COMMAND: {
				System.out.println("No valid command specified, enter \"help\" for command list");
				break;
			}
			
			default: {
				System.out.println("No valid command specified, enter \"help\" for command list");
			}
		}
		
		return mode;
	}

	@Override
	public Mode handleSQL(String input) {
		Mode mode;
		
		if(input.trim().equals("")) {
			System.out.println("Please enter a valid SQL sentence");
			mode = Mode.SQL;
		} else if(input.trim().equals("quit")) {
			mode = Mode.CLI;
		} else {
			try {
				Parser.handleSQLString(input);
				mode = Mode.SQL;
			} catch (Exception e) {
				System.out.println("Unable to parse SQL String, quitting to CLI");
				mode = Mode.CLI;
				//e.printStackTrace();
			}
		}
		
		return mode;
	}

}
