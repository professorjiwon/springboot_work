package com.study.springboot.multi;

import org.springframework.stereotype.Component;

@Component("printerB")
public class PrinterB implements Printer {

	@Override
	public void print(String msg) {
		System.out.println("Printer B : " + msg);
	}

}
