/*  This Software is a simple english to german translator used as
    an experiment
    Copyright (C) 2016  Christopher Truebig

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package com.guttranslate;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

class GutTranslator implements ActionListener {

	JTextField jtf1;
	JTextField jtf2;
	JLabel jlab;
	TransLateDao engDict = new TransLateDao("english.txt");
	TransLateDao gerDict = new TransLateDao("german.txt");

	// initialize the translator
	public GutTranslator() {

		// Create a new JFrame container.
		JFrame frame = new JFrame("GutTranslator 1.1");
		JPanel panel = new JPanel();

		// Set size of panel.

		panel.setLayout(new GridLayout());
		// Set panel color
		panel.setBackground(Color.LIGHT_GRAY);

		// Set icon
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/textEdit.png")));

		// Specify layout.
		// frame.setLayout(new FlowLayout());

		// initial frame size.
		frame.setSize(360, 95);

		// Terminate the program.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create an empty label.
		jlab = new JLabel("Enter any word");
		jlab.setForeground(Color.DARK_GRAY);
		jlab.setHorizontalAlignment(JLabel.CENTER);

		// Add the label to the frame.
		panel.add(jlab);

		// Create two text field instances.
		jtf1 = new JTextField(20);
		jtf1.setHorizontalAlignment(JTextField.CENTER);
		jtf2 = new JTextField(20);
		jtf2.setHorizontalAlignment(JTextField.CENTER);
		jtf2.setEditable(false);

		// set background color.
		jtf1.setBackground(Color.GRAY);
		jtf2.setBackground(Color.DARK_GRAY);

		// Set the borders.
		jtf1.setBorder(null);
		jtf2.setBorder(null);

		// set foreground color.
		jtf1.setForeground(Color.WHITE);
		jtf2.setForeground(Color.LIGHT_GRAY);

		// Set action commands.
		jtf1.setActionCommand("One");
		jtf2.setActionCommand("Two");

		// Add action listeners
		jtf1.addActionListener(this);
		jtf2.addActionListener(this);

		// Add to the content pane.
		panel.add(jtf1);
		panel.add(jtf2);

		// Add panel to the frame.
		frame.add(panel);

		// Display the frame.
		frame.setVisible(true);
		frame.setResizable(false);

	}

	// Handle the events.
	public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand().equals("One")) {
			String text = jtf1.getText();

			if (text.equals("clear")) {
				jtf1.setText("");
				jtf2.setText("");
			} 
			else if (engDict.hasWord(text)) {
				int index = engDict.getIndex(text);
				jtf2.setText(gerDict.getWord(index));
			} 
			else if (gerDict.hasWord(text)) {
				int index = gerDict.getIndex(text);
				jtf2.setText(engDict.getWord(index));
			} 
			else {
				jtf2.setText("Check your \nspelling :(");
			}
		}

	}

	public static void main(String[] args) {

		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GutTranslator();
			}
		});
	}
}
