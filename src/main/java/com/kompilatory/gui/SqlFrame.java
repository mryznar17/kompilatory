package com.kompilatory.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class SqlFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtField;
	private String path;
	
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
				} catch(NullPointerException e) {
				}
			}
			private void generateButtonActionPerformed(ActionEvent evt) {
				path = txtField.getText();
				System.out.println(path);
				// TO DO: Wszystko, czyli tworzenie i rysowanie diagramow
			}
		});
		panel.add(generateButton);
	}

}