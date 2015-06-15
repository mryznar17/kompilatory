package com.kompilatory.model;

import java.util.HashMap;
import java.util.LinkedList;

public class TestTabela {

	public static void main(String[] args) {
		Tabela tab = new Tabela();
		HashMap <String, String> atrybuty = new HashMap<String, String>();
		LinkedList<String> powiazania = new LinkedList<String>();
		
		atrybuty.put("test_kluczGlowny", "serial primary key");
		atrybuty.put("test_kluczObcy", "varchar(10) references test2(test2_kluczGlowny)");
		atrybuty.put("test_zwyklyAtrybut", "text");
		
		tab.setAtrybuty(atrybuty);
		tab.szukajPowiazan();
		powiazania = tab.getPowiazania();
		
		for(String lista : powiazania)
			System.out.println(lista);
	}

}
