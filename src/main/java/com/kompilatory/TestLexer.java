package com.kompilatory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;

import com.kompilatory.lexers.SqlLexer;

import de.sciss.syntaxpane.Token;

public class TestLexer {

	public static void main(String[] args) throws IOException {
		String init="init.sql";
		//BufferedReader buffer = new BufferedReader(new FileReader(init));
		//System.out.println(buffer.readLine());
		InputStream inputstream = new FileInputStream(init);
		SqlLexer scanner = new SqlLexer(inputstream);
		//do zczytywania po kolei tokenów
		Token tok;
		tok = scanner.next_token2();
		int i=1;
		while(tok!=null)
		{	
			System.out.println("Token "+i+":"+tok.toString()+" :"+scanner.yytext());
			tok = scanner.next_token2();
			i++;
		}
		
		

	}

}
