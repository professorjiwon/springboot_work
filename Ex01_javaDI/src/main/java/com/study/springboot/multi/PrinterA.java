package com.study.springboot.multi;

public class PrinterA implements Printer {

	@Override
	public void print(String msg) {
		System.out.println("Printer A : " + msg);
	}

}
