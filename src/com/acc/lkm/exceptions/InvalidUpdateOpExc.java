package com.acc.lkm.exceptions;


@SuppressWarnings("Serialize")
public class InvalidUpdateOpExc extends Exception{
	public InvalidUpdateOpExc() {
		super("Enter Patiend User ID doesn't exist.Please enter a valid User ID");
	}

}
