package com.kompilatory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.kompilatory.lexers.SqlLexer;
import com.kompilatory.model.Tabela;
import com.kompilatory.parser.SqlCup;

public class TestSqlParser {

	public static void main(String[] args) throws FileNotFoundException {
		String init="init3.sql";

		InputStream inputstream = new FileInputStream(init);
		SqlLexer scanner = new SqlLexer(inputstream);
		
		SqlCup parser = new SqlCup(scanner);

		try {
			String p = (String) parser.parse().value;
			System.out.println("test");
			System.out.println(p);
		} catch (Exception e) {
			System.out.println("NULLLLLLLLLLLLLLLLL exception");
			e.printStackTrace();
		}
		
		Tabela tmp = parser.getTabela();
		System.out.println("Test tabeli: ");
		System.out.println(tmp.getNazwa());
		
		List<Tabela> tabs= parser.getTabele();
		System.out.println("Wielkosc listy: "+tabs.size());
		for(Tabela t:tabs)
		{
			//System.out.println(t.getNazwa());
		}
		if(parser==null) System.out.println("Parser jest nullem");
	}

}