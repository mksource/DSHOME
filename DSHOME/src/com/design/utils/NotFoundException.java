package com.design.utils;

public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8255182302764335372L;
	
	public NotFoundException(String reason)
	{
		super(reason);
	}

}
