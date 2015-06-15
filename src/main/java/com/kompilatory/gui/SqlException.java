package com.kompilatory.gui;

import javax.swing.JOptionPane;

public class SqlException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Ustawia komunikat do wyrzucenia
	 * @param msg komunikat
	 */
	public SqlException(String msg) {
		super(msg);
	}
	
	/**
	 * Wyswietla komunikat w okienku wiadomosci
	 */
	public void showDialog() {
		JOptionPane.showMessageDialog(null, getMessage());
	}
}
