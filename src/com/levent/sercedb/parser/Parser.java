package com.levent.sercedb.parser;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import com.levent.sercedb.model.SQLModel;
import com.levent.sercedb.model.SQLVerb;

public class Parser {
	
	private static StringTokenizer tokenizer;
	private static List<String> list;
	
	public static SQLModel handleSQLString(String in) throws Exception {
		getTokens(in);
		return processTokens();
	}
	
	private static void getTokens(String in) throws Exception {
		in = in.toLowerCase();
		tokenizer = new StringTokenizer(in);
		list = new LinkedList<>();
		
		while(tokenizer.hasMoreElements()) {
			list.add((String) tokenizer.nextElement());
		}
		
		if(list.size() < 4) {
			throw new Exception("SQL tokens cannot be smaller than 4");
		}
	}
	
	/*
	 * index 0: sql verb
	 * index 1: sql target
	 * index 2: must be equal to "from"
	 * index 3: sql table name
	 */
	private static SQLModel processTokens() throws Exception {
		SQLModel sql = new SQLModel();
		
		switch(list.get(0)) {
			case "select": {
				sql.setVerb(SQLVerb.SELECT);
				break;
			}
			
			case "insert": {
				sql.setVerb(SQLVerb.INSERT);
				break;
			}

			case "update": {
				sql.setVerb(SQLVerb.UPDATE);
				break;
			}
			
			case "delete": {
				sql.setVerb(SQLVerb.DELETE);
				break;
			}
			
			default: {
				throw new Exception("Invalid SQL Verb: " + list.get(0));
			}
			
		}
		
		sql.setTarget(list.get(1));
		
		if(!list.get(2).equals("from")) {
			throw new Exception("Invalid SQL Token: " + list.get(2));
		}
		
		sql.setTableName(list.get(3));
		
		return sql;
	}
	
}
