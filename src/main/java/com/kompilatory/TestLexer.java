package com.kompilatory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.kompilatory.lexers.SqlLexer;

import de.sciss.syntaxpane.Token;

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
<<<<<<< HEAD

			System.out.println("Token "+i+":"+tok.toString());//+" :"+scanner.yytext());
			tok = scanner.next_token2();

//			System.out.println("Token "+i+": "+tok.toString()+" : "+scanner.yytext());
//			tok = scanner.yylex();

=======
			System.out.println("Token "+i+":"+tok.toString()+" :"+scanner.yytext());
			tok = scanner.next_token2();
			System.out.println("Token "+i+": "+tok.toString()+" : "+scanner.yytext());
			tok = scanner.yylex();
>>>>>>> 622e83fc860a56fbbc5e6dccc14610a5c24afe9c
			i++;
		}
		
		

	}

}
