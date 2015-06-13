package com.kompilatory.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Tabela {
	private String nazwa;
	private HashMap <String, String> atrybuty;	// <nazwa, typ_atrybutu> typ_atrybutu zawiera rowniez magiczne dodatki (tj. not null, primary, references.. etc)
	private LinkedList<String> powiazania;		// "atr_name tab_name atr2_name"
	
	public void szukajPowiazan() {
		Iterator<?> it = atrybuty.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if(pair.getValue().toString().contains("references")) { //spr_idklienta varchar(10) references hurt.klienci(kli_idklienta)
	        	String atr1_name = pair.getKey().toString();
	        	String[] refSplit = pair.getValue().toString().split("references");
	        	String tab_name = refSplit[1].substring(1, refSplit[1].indexOf("("));
	        	String atr2_name = refSplit[1].substring(refSplit[1].indexOf("("), refSplit[1].indexOf(")")); 
	        	powiazania.add(atr1_name+" "+tab_name+" "+atr2_name);
	        }
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }
	}
}