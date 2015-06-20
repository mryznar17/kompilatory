package com.kompilatory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java_cup.runtime.Symbol;
import jsyntaxpane.Token;


import com.kompilatory.lexers.SqlLexer;
import com.kompilatory.parser.sym;

public class TestLexer {



	public static void main(String[] args) throws IOException {
		String init="init2.sql";
		//BufferedReader buffer = new BufferedReader(new FileReader(init));
		//System.out.println(buffer.readLine());
		InputStream inputstream = new FileInputStream(init);
		SqlLexer scanner = new SqlLexer(inputstream);
		//do sczytywania po kolei tokenow
		Symbol tok;
		tok = scanner.next_token();
		//sym s;
		
		int i=1;
		while(tok!=null)
		{	

			//System.out.println("Token "+i+":"+tok.sym);//+" :"+scanner.yytext());
			//System.out.println(s.terminalNames[tok.sym]);
			//tok.sym
			tok = scanner.next_token();
			i++;
		}
	}

}
