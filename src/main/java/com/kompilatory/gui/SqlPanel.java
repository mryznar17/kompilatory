package com.kompilatory.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JPanel;

import com.kompilatory.model.Tabela;

public class SqlPanel extends JPanel implements Printable {
	private static final long serialVersionUID = 1L;
	private Tabela tab = null;
	private HashMap <String, String> atrybuty = null;
	private LinkedList<String> powiazania = null;
	Iterator<?> it = null;
	Map.Entry pair = null;
	private int x;
	private int y;
	private int TAB_WIDTH;
	private int TAB_HEIGHT;
	
	public void genSqlPanel() {
		tab = new Tabela();
		atrybuty = new HashMap<String, String>();
		powiazania = new LinkedList<String>();
		
		x = 100;
		y = 100;
		TAB_WIDTH = 0;
		TAB_HEIGHT = 0;
		
		atrybuty.put("test_kluczGlowny", "serial primary key");
		atrybuty.put("test_kluczObcy", "varchar(10) references test2(test2_kluczGlowny)");
		atrybuty.put("test_zwyklyAtrybut", "text");
	    
		tab.setNazwa("Test");
		tab.setAtrybuty(atrybuty);
		tab.szukajPowiazan();
		powiazania = tab.getPowiazania();
		repaint();
	}
	
	@Override
    public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setFont(new Font("default", Font.PLAIN, 12));
		
		if(tab != null) {
			it = tab.getAtrybuty().entrySet().iterator();
			for(int i =0; it.hasNext(); i++) {
				TAB_HEIGHT += 1;
				pair = (Map.Entry)it.next();
				if(TAB_WIDTH < pair.toString().length())
					TAB_WIDTH = pair.toString().length();
			}
			TAB_HEIGHT *= 15;
			
			g2d.setColor(Color.BLUE);
			g2d.fill(new Rectangle2D.Double(x, y, TAB_WIDTH*6, TAB_HEIGHT));
			
			it = tab.getAtrybuty().entrySet().iterator();
			g2d.setColor(Color.RED);
			g2d.drawString(tab.getNazwa(), x, y);
			y += 15;
			g2d.setColor(Color.BLACK);
			for(int i = 0; it.hasNext(); i++) {
				pair = (Map.Entry)it.next();
				g2d.drawString(pair.toString(), x, y+15*i);
			}
		}
	}
	
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		this.paint(g2d);
		
		return PAGE_EXISTS;
	}
}
