package me.ressources.graphics;

import java.awt.Color;

import javax.swing.JPanel;

public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;

	public Panel() {
		this.setBackground(Color.LIGHT_GRAY);
	}
	
	public Panel(Color color) {
		this.setBackground(color);
	}
}
