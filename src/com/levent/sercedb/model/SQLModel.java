package com.levent.sercedb.model;

public class SQLModel {

	private SQLVerb verb;
	private String target;
	private String tableName;

	public SQLVerb getVerb() {
		return verb;
	}

	public void setVerb(SQLVerb verb) {
		this.verb = verb;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	public String toString() {
		return String.format("Verb: %s - Target: %s - Table: %s%n", this.verb, this.target, this.tableName);
	}

}
