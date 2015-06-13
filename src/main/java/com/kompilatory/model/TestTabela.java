package com.kompilatory.model;

import java.util.HashMap;
import java.util.LinkedList;

public class TestTabela {

	public static void main(String[] args) {
		Tabela tab = new Tabela();
		HashMap <String, String> atrybuty = new HashMap<String, String>();
		LinkedList<String> powiazania = new LinkedList<String>();
		
		atrybuty.put("usr_idmusztardy", "serial primary key");
		atrybuty.put("spr_idklienta", "varchar(10) references hurt.klienci(kli_idklienta)");
		atrybuty.put("usr_emailbudyniu", "text");
		
		tab.setAtrybuty(atrybuty);
		tab.szukajPowiazan();
		powiazania = tab.getPowiazania();
		
		for(String lista : powiazania)
			System.out.println(lista);
	}

}
