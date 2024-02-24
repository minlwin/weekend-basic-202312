package com.jdc.application;

public abstract class Operation {

	private int id;
	private String name;
	protected Inputs inputs;

	public Operation(int id, String name, Inputs inputs) {
		this.id = id;
		this.name = name;
		this.inputs = inputs;
	}

	public void doOperation() {
		showMenu();
		System.out.println();
		internalOperation();
	}
	
	protected abstract void internalOperation();

	public void showMenu() {
		System.out.println("%d. %s".formatted(id, name));
	}
	
	public int getId() {
		return id;
	}
}
