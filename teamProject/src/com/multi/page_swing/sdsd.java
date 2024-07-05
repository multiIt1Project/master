package com.multi.page_swing;

import javax.swing.*;
import java.awt.*;

public class sdsd {
	
	public static void main(String[] args) {
		
		
		JFrame frame = new JFrame("GridBagLayout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel midP = new JPanel(); // 가운데
		midP.setBackground(new Color(40, 60, 79));
		midP.setBorder(BorderFactory.createEmptyBorder(30, 10, 0, 10)); // 여백(=padding)
		midP.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		Font font1 = new Font("Arial", Font.BOLD, 16);
		Font font2 = new Font("Arial", Font.PLAIN, 14);
		
		// JLabel 3
		JLabel label3 = new JLabel("Label 3");
		label3.setFont(font2);
		label3.setForeground(Color.white);
		gbc.gridx = 0; // Start in column 0
		gbc.gridy = 0; // First row
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets.set(5, 5, 5, 5);
		midP.add(label3, gbc);
		
		// JLabel 1 and JTextField 1
		JLabel label1 = new JLabel("Label 1");
		label1.setFont(font2);
		label1.setForeground(Color.white);
		gbc.gridy = 1; // Next row (second row)
		midP.add(label1, gbc);
		
		JTextField textField1 = new JTextField(20);
		gbc.gridx = 1; // Next column (column 1)
		midP.add(textField1, gbc);
		
		// JLabel 2 and JTextField 2
		JLabel label2 = new JLabel("Label 2");
		label2.setFont(font2);
		label2.setForeground(Color.white);
		gbc.gridx = 0; // Start in column 0
		gbc.gridy = 2; // Next row (third row)
		midP.add(label2, gbc);
		
		JTextField textField2 = new JTextField(20);
		gbc.gridx = 1; // Next column (column 1)
		midP.add(textField2, gbc);
		
		// JButton (spans two columns)
		JButton button = new JButton("Button");
		gbc.gridx = 0; // Start in column 0
		gbc.gridy = 3; // Next row (fourth row)
		gbc.gridwidth = 2; // Span across two columns
		midP.add(button, gbc);
		
		// JTextArea (spans two columns)
		JTextArea textArea = new JTextArea(5, 20);
		gbc.gridy = 4; // Next row (fifth row)
		gbc.gridwidth = 2; // Span across two columns
		midP.add(textArea, gbc);
		
		frame.getContentPane().add(midP);
		frame.pack();
		frame.setVisible(true);
	}
}
