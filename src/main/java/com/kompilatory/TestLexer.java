package com.kompilatory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jsyntaxpane.Token;

import com.kompilatory.lexers.SqlLexer;



public class TestLexer {

	public static void main(String[] args) throws IOException {
		String init="init.sql";
		//BufferedReader buffer = new BufferedReader(new FileReader(init));
		//System.out.println(buffer.readLine());
		InputStream inputstream = new FileInputStream(init);
		SqlLexer scanner = new SqlLexer(inputstream);
		//do zczytywania po kolei tokenow
		Token tok;
		tok = scanner.next_token2();

		int i=1;
		while(tok!=null)
		{	

			System.out.println("Token "+i+":"+tok.toString());//+" :"+scanner.yytext());
			tok = scanner.next_token2();


			i++;
		}
		
		

	}

}
