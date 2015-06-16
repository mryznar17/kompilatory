package com.kompilatory.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.kompilatory.model.Tabela;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class SqlFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private LinkedList <Tabela> tabs = null;
	private HashMap <String, String> atrybuty = null;
	private LinkedList<String> powiazania = null;
	private LinkedList<Object> vectors = null;
	private Object v = null;
	private Iterator<?> it = null;
	private Map.Entry pair = null;
	private int x;
	private int y;
	private int TAB_WIDTH;
	private int TAB_HEIGHT;
	private JTextField txtField;
	private String path = null;
	private String nl = "\n";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SqlFrame frame = new SqlFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SqlFrame() {
		setTitle("ERD Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));
		
		JButton searchButton = new JButton("...");
		searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					searchButtonActionPerformed(evt);
				} catch (SqlException e) {
					e.showDialog();
				}
            }
			private void searchButtonActionPerformed(ActionEvent evt) throws SqlException {
				String path = SqlFrame.class.getProtectionDomain().getCodeSource().getLocation().getPath();
				String decodedPath;
				try {
					decodedPath = URLDecoder.decode(path, "UTF-8");

					JFileChooser searchFile = new JFileChooser(decodedPath);
					searchFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
					
			        if(searchFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			        {
			            File f = searchFile.getSelectedFile();
			            txtField.setText(f.getAbsolutePath());
			        }
				} catch (UnsupportedEncodingException e) {
					throw new SqlException("File encoding error");
				}
			}
        });
		
		txtField = new JTextField();
		txtField.setText("path..");
		panel.add(txtField);
		txtField.setColumns(40);
		panel.add(searchButton);
		
		JButton generateButton = new JButton("Generate ERD");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					try {
						generateButtonActionPerformed(evt);
					} catch (SqlException e) {
						e.showDialog();
					}
				} catch(NullPointerException e) {
				}
			}
			private void generateButtonActionPerformed(ActionEvent evt) throws SqlException {
				path = txtField.getText();
				tabs = new LinkedList<Tabela>();
				
				/*if(path == null || path.equals("path..")) {
					throw new SqlException("No file chosen");
				}
				else{*/
					genSqlTable();
					generateERD();
				//}
			}
		});
		panel.add(generateButton);
		
	}
	
	public void generateERD() {
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		vectors = new LinkedList<Object>();

		graph.getModel().beginUpdate();
		try
		{
			v = graph.insertVertex(parent, null, tableToString(tabs.get(0)), 100, 100, TAB_WIDTH, TAB_HEIGHT);
			vectors.add(v);
			v = graph.insertVertex(parent, null, tableToString(tabs.get(1)), 200, 200, TAB_WIDTH, TAB_HEIGHT);
			vectors.add(v);
			v = graph.insertVertex(parent, null, tableToString(tabs.get(2)), 300, 300, TAB_WIDTH, TAB_HEIGHT);
			vectors.add(v);
			
			//graph.insertEdge(parent, null, "", vectors.get(0), vectors.get(1));
			//graph.insertEdge(parent, null, "", vectors.get(0), vectors.get(2));
			
			for(int i = 0; i < vectors.size(); i++) {
				System.out.println("iteracja 'i': "+i);
				System.out.println("rozmiar 'i': "+vectors.size());
				for(int j = 0; j < tabs.get(i).getPowiazania().size(); i++) {
					System.out.println("iteracja 'j': "+j);
					System.out.println("rozmiar 'j': "+tabs.get(i).getPowiazania().size());
					//System.out.println(tabs.get(i).getPowiazania().get(j).toString());
					String[] powSplit = tabs.get(i).getPowiazania().get(j).split(" ");
					for(int x = 0; x < tabs.size(); x++) {
						System.out.println("iteracja 'x': "+x);
						System.out.println("rozmiar 'x': "+tabs.size());
						//System.out.println(tabs.get(i).getNazwa() + "  :  "+tabs.get(x).getNazwa());
						//System.out.println(powSplit[1].toLowerCase() +"  :  "+(tabs.get(x).getNazwa().toLowerCase()));
						if((tabs.get(i) != tabs.get(x)) && powSplit[1].toLowerCase().equals(tabs.get(x).getNazwa().toLowerCase())) {
							//graph.insertEdge(parent, null, "", vectors.get(i), vectors.get(x));
						}
					}
				}
			}
			
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
		revalidate();
		repaint();
	}
	
	public void genSqlTable() {
		//hardcodowanie tabeli 1:
		Tabela tab = new Tabela();
		atrybuty = new HashMap<String, String>();
		powiazania = new LinkedList<String>();
		
		x = 100;
		y = 100;
		
		atrybuty.put("test_kluczGlowny", "serial primary key");
		atrybuty.put("test_kluczObcy1", "varchar(10) references test2(test2_kluczGlowny)");
		atrybuty.put("test_kluczObcy2", "integer references test3(test3_kluczGlowny)");
		atrybuty.put("test_zwyklyAtrybut", "text");
		
		tab.setNazwa("Test");
		tab.setAtrybuty(atrybuty);
		tab.szukajPowiazan();
		powiazania = tab.getPowiazania();
		
		tabs.add(tab);
		
		/*
		System.out.println("NAZWA: "+tab.getNazwa());
		System.out.println("KLUCZ GLOWNY: "+tab.getKluczGlowny());
		System.out.println("ATRYBUTY:");
		it = tab.getAtrybuty().entrySet().iterator();
		for(int i = 0; it.hasNext(); i++) {
			pair = (Map.Entry)it.next();
			System.out.println("KLUCZ: "+pair.getKey()+"\nWARTOSC: "+pair.getValue());
		}
		System.out.println("KLUCZE OBCE: ");
		for(int i = 0; i < tab.getPowiazania().size(); i++)
			System.out.println(tab.getPowiazania().get(i).toString());
		*/
			
		//hardcodowanie tabeli 2:
		tab = new Tabela();
		atrybuty = new HashMap<String, String>();
		powiazania = new LinkedList<String>();
		
		atrybuty.put("test2_kluczGlowny", "varchar(10) primary key");
		atrybuty.put("test2_zwyklyAtrybut", "text");
		tab.setNazwa("Test2");
		tab.setAtrybuty(atrybuty);
		tab.szukajPowiazan();
		powiazania = tab.getPowiazania();
		tabs.add(tab);
		
		//hardcodowanie tabeli 3:
		tab = new Tabela();
		atrybuty = new HashMap<String, String>();
		powiazania = new LinkedList<String>();
		
		atrybuty.put("test3_kluczGlowny", "integer primary key");
		atrybuty.put("test3_zwyklyAtrybut1", "text");
		atrybuty.put("test3_zwyklyAtrybut2", "text");
		atrybuty.put("test3_zwyklyAtrybut3", "text");
		tab.setNazwa("Test3");
		tab.setAtrybuty(atrybuty);
		tab.szukajPowiazan();
		powiazania = tab.getPowiazania();
		tabs.add(tab);
	}
	
	public String tableToString(Tabela tab) {
		boolean fkFound = false;
		if(tab.getKluczGlowny() != null)
			TAB_WIDTH = tab.getKluczGlowny().length();
		else
			TAB_WIDTH = 0;
		TAB_HEIGHT = 1;
		it = tab.getAtrybuty().entrySet().iterator();
		for(int i = 0; it.hasNext(); i++) {
			TAB_HEIGHT += 1;
			pair = (Map.Entry)it.next();
			String[] varSplit = pair.getValue().toString().split(" ");
			if(TAB_WIDTH < pair.getKey().toString().length()+varSplit[0].length())
				TAB_WIDTH = pair.getKey().toString().length()+varSplit[0].length();
		}
		TAB_WIDTH *= 6;
		TAB_HEIGHT *= 20;
		
		String znak_ = new String(new char[(TAB_WIDTH-tab.getNazwa().length())/13]).replace("\0", "_");
		String s = znak_+tab.getNazwa().toString().toUpperCase()+znak_;
		if(tab.getKluczGlowny() != null)
			s += nl+tab.getKluczGlowny();
		it = tab.getAtrybuty().entrySet().iterator();
		for(int i =0; it.hasNext(); i++) {
			fkFound = false;
			pair = (Map.Entry)it.next();
			String[] varSplit = pair.getValue().toString().split(" ");
			if(tab.getPowiazania().size() != 0) {
				for(int j = 0; j < tab.getPowiazania().size(); j++) {
					if(tab.getPowiazania().get(j).contains(pair.getKey().toString())) {
						s += nl+pair.getKey()+"(FK) : "+varSplit[0];
						fkFound = true;
						break;
					}
				}
				if(fkFound != true)
					s += nl+pair.getKey()+" : "+varSplit[0];
			} else
				s += nl+pair.getKey()+" : "+varSplit[0];
		}
		return s;
	}
	
}