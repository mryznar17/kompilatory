	package com.kompilatory.lexers;
	import java.util.*;
	import java_cup.runtime.Symbol;
	import java_cup.runtime.*;
	import com.kompilatory.parser.sym;

%%

%public
%class SqlLexer
%line
%column
%cup


%{
/*
	Ten kod zostanie wstawiony do wygenerowanej klasy skanera.
*/

	private static final boolean printToken = true;
	/**
	*	Metoda tworzy nowy Symbol (token) wraz z okresleniem jego pozycji, bez wartosci.
	**/
	private Symbol symbol(int type){
		if(printToken) System.out.println("TOKEN: " + type);
		return new Symbol(type, yyline, yycolumn);
	}

	/**
	*	Metoda tworzy nowy Symbol (token) wraz z okresleniem jego pozycji i wartosci.
	**/
	private Symbol symbol(int type, Object value){
		if(printToken) System.out.println("TOKEN: " + type);
		//System.out.println("  " + value);
		return new Symbol(type, yyline, yycolumn, value);
	}
	
	/**
	*	Metoda obslugujaca bledy
	**/
	private void error(String message) {
    	System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
  }
%}
/* Definicja terminali:*/
	DIGIT = [0-9]
	INTEGER = {DIGIT}+
	REAL	= {INTEGER}[.][0-9]+
	/* NUMBER	= {INTEGER}|{REAL} */
	
	/*VARCHAR = [varchar]({INTEGER})*/
	/* STRING = {VARCHAR} | {TEXT} */
	
	WHITE_SPACE		= [ \t\f]
	INPUT_CHARACTER = [^\r\n]
	LINE_SEPARATOR	= \r  | \n | \r\n
	
	COMMENT = {TRADITIONAL_COMMENT} | {END_OF_LINE_COMMENT} | {DOCUMENTATION_COMMENT}

	TRADITIONAL_COMMENT = "/*" [^*] ~"*/" | "/*" "*"+ "/"
	DOCUMENTATION_COMMENT = "/**" {COMMENT_CONTENT} "*"+ "/"
	COMMENT_CONTENT       = ( [^*] | \*+ [^/*] )*
	END_OF_LINE_COMMENT = "--" {INPUT_CHARACTER}* {LINE_SEPARATOR}?
	
	IDENTIFIER		= [:jletter:][:jletterdigit:]*
	
%%

/*	<YYINITIAL>{ */
		//TODO: litery duze i male
				/* keywords */
		"create"		{ return symbol(sym.CREATE); }
		"table"			{ return symbol(sym.TABLE); }
		"if"			{ return symbol(sym.IF); }	
		"not"			{ return symbol(sym.NOT); }
		"exists"		{ return symbol(sym.EXISTS); }
		"primary"		{ return symbol(sym.PRIMARY); }
		"key"			{ return symbol(sym.KEY); }
		"references"	{ return symbol(sym.REFERENCES); }
		
				/* types */
		{INTEGER}		{ return symbol(sym.INTEGER,new Integer(yytext())); }
		{REAL}			{ return symbol(sym.REAL,new Double(yytext())); }
		"varchar"		{ return symbol(sym.VARCHAR); }
		"boolean"		{ return symbol(sym.BOOLEAN); }
		"char"			{ return symbol(sym.CHAR); }
		"null"			{ return symbol(sym.NULL); }
		"numeric"		{ return symbol(sym.NUMERIC); }
		"smallint"		{ return symbol(sym.SMALLINT); }
		"text"			{ return symbol(sym.TEXT); }
		"timestamp"		{ return symbol(sym.TIMESTAMP); }
		"date"			{ return symbol(sym.DATE); }
		"serial"		{ return symbol(sym.SERIAL); }
		"integer"		{ return symbol(sym.INTEGER_TYPE); }
		"real"			{ return symbol(sym.REAL_TYPE); }
		
			/* operators */
		"("				{ return symbol(sym.LBRACKET); }
		")"				{ return symbol(sym.RBRACKET); }
		";"				{ return symbol(sym.APOSTROPHE); }
		","				{ return symbol(sym.COMMA); }
		
		{LINE_SEPARATOR}	{ /* return symbol(sym.NEW_LINE); */ }
			
		{COMMENT}			{ /* Ignorujemy komentarze */ }
		{WHITE_SPACE}		{ /* Ignorujemy biale znaki */ }
		
		{IDENTIFIER}		{ return symbol(sym.ID, new String(yytext())); }
		
/*	} */
	
		/* error fallback */
.|\n              {  /* throw new Error("Illegal character <"+ yytext()+">");*/
		    error("Illegal character <"+ yytext()+">");
                  }
<<EOF>>           { return null; }