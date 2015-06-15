	import java.util.*;
	import java_cup.runtime.Symbol;
	import java_cup.runtime.*;

%%

%class Scanner
%line
%column
%cup
%eofval{

	return (symbol(sym.EOF));

%eofval}

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
	
%}

	INTEGER = 0 | [1-9][0-9]*
	REAL	= {INTEGER}[.][0-9]+
	NUMBER	= {INTEGER}|{REAL}
	
	LINE_SEPARATOR	= \r  | \n | \r\n
	
%%

	<YYINITIAL>{
		{NUMBER}			{ return symbol(sym.NUMBER, new Double(yytext())); }
		
		{LINE_SEPARATOR}	{ return symbol(sym.NEW_LINE); }
		
	}