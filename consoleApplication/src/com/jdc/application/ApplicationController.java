package com.jdc.application;

import java.util.Map;

import com.jdc.application.ApplicationException.Type;

public class ApplicationController {

	private Inputs inputs;
	private Map<Integer, Operation> operations;
	
	public ApplicationController(Inputs inputs, Map<Integer, Operation> operations) {
		super();
		this.inputs = inputs;
		this.operations = operations;
	}

	public void launch() {
		// Show Title
		System.out.println("""
				============================
				Welcome! Teacher
				============================""");
		
		var missingCount = 0;

		while(true) {
			
			try {
				var operation = getOperation();
				
				if(null == operation) {
					missingCount ++;

					if(missingCount < 3) {
						throw new ApplicationException(Type.IVALID, "Operation ID");
					}
					
					throw new ApplicationException(Type.EXEED_MAX_MISSING_COUNT);
				}
				
				operation.doOperation();
			} catch (ApplicationException e) {
				if(e.getType() == Type.EXIT) {
					break;
				}
				
				if(e.getType() == Type.BLANK) {
					System.out.println("Please enter %s.%n".formatted(e.getField()));
					continue;
				}
				
				if(e.getType() == Type.NAN) {
					System.out.println("Please enter %s with digit.%n".formatted(e.getField()));
					continue;
				}
				
				if(e.getType() == Type.IVALID) {
					System.out.println("Please enter valid %s.%n".formatted(e.getField()));
					continue;
				}
				
				if(e.getType() == Type.EXEED_MAX_MISSING_COUNT) {
					System.out.println("You exeed maximun missing count.");
					break;
				}
			}
			
		}

		System.out.println("""
				============================
				Thank you
				============================""");
	}

	private Operation getOperation() {
		
		System.out.println("Select Operation");
		for(var operation : operations.values()) {
			operation.showMenu();
		}

		System.out.println();
		var operationId = inputs.readInt("Operation ID");
		return operations.get(operationId);
	}

}
