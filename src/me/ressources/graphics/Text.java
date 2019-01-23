package me.ressources.graphics;

import java.awt.Font;

import javax.swing.JLabel;

public class Text extends JLabel{

	private static final long serialVersionUID = 1L;
	
	public Text(String text, int x, int y, int locX, int locY) {
		this.setText(text);
		this.setSize(50, 50);
		this.setLocation(locX, locY);
	}
	
	public Text(String text, int x, int y, int locX, int locY, Font font) {
		this.setText(text);
		this.setSize(x, y);
		this.setFont(font);
		this.setLocation(locX, locY);
	}
}
