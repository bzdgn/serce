package com.levent.sercedb.cli;

public interface ModeHandler {
	
	public Mode handleCLI(Command command);
	public Mode handleSQL(String input);
	
}
