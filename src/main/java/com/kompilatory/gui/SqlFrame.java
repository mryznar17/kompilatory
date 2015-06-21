package com.kompilatory.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.kompilatory.lexers.SqlLexer;
import com.kompilatory.model.Tabela;
import com.kompilatory.parser.SqlCup;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class SqlFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private LinkedList <Tabela> tabs = null;
	private LinkedList<Object> vectors = null;
	private Object v = null;
	private Iterator<?> it = null;
	private Map.Entry pair = null;
	private InputStream inputstream;
	private static int x;
	private static int y;
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
					generateButtonActionPerformed(evt);
				} catch (SqlException e) {
					e.showDialog();
				} catch(NullPointerException e) {
					
				}
			}
			private void generateButtonActionPerformed(ActionEvent evt) throws SqlException {
				path = txtField.getText();
				System.out.println(path);
				if(path == null) {
					throw new SqlException("No such file or no file chosen");
				}
				else {
					genSqlTables();
					generateERD();
				}
			}
		});
		panel.add(generateButton);
		
	}
	
	public void generateERD() {
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		vectors = new LinkedList<Object>();
		graph.getModel().beginUpdate();
		
		try {
			// generowanie tabel encji
			for(int i = 0; i < tabs.size(); i++) {
				v = graph.insertVertex(parent, null, tableToString(tabs.get(i)), x*(i+1), y*(i+1), TAB_WIDTH, TAB_HEIGHT);
				vectors.add(v);
			}
			
			// laczenie encji strzalkami na podstawie kluczy obcych
			for(int i = 0; i < vectors.size(); i++) {
				for(int j = 0; j < tabs.get(i).getPowiazania().size(); j++) {
					String[] powSplit = tabs.get(i).getPowiazania().get(j).split(" ");
					for(int x = 0; x < tabs.size(); x++) {
						if((tabs.get(i) != tabs.get(x)) && powSplit[1].toLowerCase().equals(tabs.get(x).getNazwa().toLowerCase())) {
							graph.insertEdge(parent, null, "", vectors.get(i), vectors.get(x), "endArrow=none");
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
	
	public void genSqlTables() throws SqlException {
		try {
			tabs = new LinkedList<Tabela>();
			inputstream = new FileInputStream(path);
			SqlLexer scanner = new SqlLexer(inputstream);
			SqlCup parser = new SqlCup(scanner);
			String p = (String) parser.parse().value;
			tabs = (LinkedList<Tabela>) parser.getTabele();
		} catch (FileNotFoundException e) {
			throw new SqlException("No such file or no file chosen");
		} catch (Exception e) {
			throw new SqlException("Syntax error in your file");
		}
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
		TAB_WIDTH *= 7;
		TAB_HEIGHT *= 25;
		
		String line_ = new String(new char[(TAB_WIDTH/10)]).replace("\0", "_");
		String s = tab.getNazwa().toString().toUpperCase()+nl+line_;
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