package com.study.springboot.multi;

public class PrinterB implements Printer {

	@Override
	public void print(String msg) {
		System.out.println("Printer B : " + msg);
	}

}
