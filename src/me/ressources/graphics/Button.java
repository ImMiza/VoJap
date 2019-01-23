package me.ressources.graphics;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Button extends JButton{

	private static final long serialVersionUID = 1L;
	
	private String text;
	private int x, y, locX, locY;
	private MouseListener listener;
	
	public Button(String text, int x, int y, int locX, int locY) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.locX = locX;
		this.locY = locY;
		this.listener = null;
		
		this.setText(text);
		this.setLocation(locX, locY);
		this.setSize(x, y);
		this.setBackground(Color.WHITE);
	}
	
	public Button(String text, int x, int y, int locX, int locY, MouseListener listener) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.locX = locX;
		this.locY = locY;
		this.listener = listener;
		
		this.setText(text);
		this.setLocation(locX, locY);
		this.setSize(x, y);
		this.setBackground(Color.WHITE);
		this.addMouseListener(listener);
	}
	
	public Button(String text, int x, int y, int locX, int locY, Color color) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.locX = locX;
		this.locY = locY;
		this.listener = null;
		
		this.setText(text);
		this.setLocation(locX, locY);
		this.setSize(x, y);
		this.setBackground(color);
	}

	public String getButtonText() {
		return text;
	}

	public void setButtonText(String text) {
		this.text = text;
	}

	public int getWitdh() {
		return x;
	}

	public void setWitdh(int x) {
		this.x = x;
	}

	public int getHeigh() {
		return y;
	}

	public void setHeigh(int y) {
		this.y = y;
	}

	public int getLocX() {
		return locX;
	}

	public void setLocX(int locX) {
		this.locX = locX;
	}

	public int getLocY() {
		return locY;
	}

	public void setLocY(int locY) {
		this.locY = locY;
	}

	public MouseListener getListener() {
		return listener;
	}

	public void setListener(MouseListener listener) {
		this.listener = listener;
	}
}
