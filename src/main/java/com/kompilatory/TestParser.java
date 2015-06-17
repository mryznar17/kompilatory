package com.kompilatory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.kompilatory.lexers.Scanner;
import com.kompilatory.parser.ParserCup;

public class TestParser {

	public static void main(String[] args) throws FileNotFoundException {
		String init="init2.sql";
		//BufferedReader buffer = new BufferedReader(new FileReader(init));
		//System.out.println(buffer.readLine());
		InputStream inputstream = new FileInputStream(init);
		Scanner scanner = new Scanner(inputstream);
		ParserCup parser = new ParserCup(scanner, inputstream);
		
		try {
			parser.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(parser==null) System.out.println("Nullll!!!!!!!!");
		System.out.println(parser.getTabela().getNazwa());
	}

}
