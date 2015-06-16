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
	private Tabela tab = null;
	private HashMap <String, String> atrybuty = null;
	private LinkedList<String> powiazania = null;
	private Iterator<?> it = null;
	private Map.Entry pair = null;
	private int x;
	private int y;
	private int TAB_WIDTH;
	private int TAB_HEIGHT;
	private JTextField txtField;
	private String path;
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
				
				// TO DO: Wszystko, czyli tworzenie i rysowanie diagramow
				if(txtField == null || txtField.equals("path..")) {
					throw new SqlException("No file chosen");
				}
				else{
					genSqlTable();
					generateERD();
				}
			}
		});
		panel.add(generateButton);
		
	}
	
	public void generateERD() {
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			Object v1 = graph.insertVertex(parent, null, tableToString(tab), 100, 100, TAB_WIDTH, TAB_HEIGHT);
			Object v2 = graph.insertVertex(parent, null, tableToString(tab), 200, 200, TAB_WIDTH, TAB_HEIGHT);
			graph.insertEdge(parent, null, "", v1, v2);
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
		tab = new Tabela();
		atrybuty = new HashMap<String, String>();
		powiazania = new LinkedList<String>();
		
		x = 100;
		y = 100;
		
		atrybuty.put("test_kluczGlowny", "serial primary key");
		atrybuty.put("test_kluczObcy", "varchar(10) references test2(test2_kluczGlowny)");
		atrybuty.put("test_zwyklyAtrybut", "text");
		
		tab.setNazwa("Test");
		tab.setAtrybuty(atrybuty);
		tab.szukajPowiazan();
		powiazania = tab.getPowiazania();
	}
	
	public String tableToString(Tabela tab) {
		TAB_WIDTH = 0;
		TAB_HEIGHT = 0;
		it = tab.getAtrybuty().entrySet().iterator();
		for(int i =0; it.hasNext(); i++) {
			TAB_HEIGHT += 1;
			pair = (Map.Entry)it.next();
			if(TAB_WIDTH < pair.toString().length())
				TAB_WIDTH = pair.toString().length();
		}
		TAB_WIDTH *= 6;
		TAB_HEIGHT *= 20;
		
		String znak_ = new String(new char[(TAB_WIDTH-tab.getNazwa().length())/13]).replace("\0", "_");
		String s = znak_+tab.getNazwa().toString().toUpperCase()+znak_;
		it = tab.getAtrybuty().entrySet().iterator();
		for(int i =0; it.hasNext(); i++) {
			pair = (Map.Entry)it.next();
			s += nl+pair.getKey()+":"+pair.getValue();
		}
		return s;
	}
	
}