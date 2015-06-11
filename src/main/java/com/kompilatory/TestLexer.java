package com.kompilatory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferUnderflowException;

import com.kompilatory.lexers.SqlLexer;

public class TestLexer {

	public static void main(String[] args) throws IOException {
		String init="init.sql";
		BufferedReader buffer = new BufferedReader(new FileReader(init));
		System.out.println(buffer.readLine());
		
		int c=0;
		while((c = buffer.read()) != -1) 
		{
			char buf = (char) c;
			SqlLexer scanner = new SqlLexer();
		}

	}

}
