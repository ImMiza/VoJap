package me.ressources.graphics;


import javax.swing.JFrame;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private String title;
	private int x, y;
	private Panel panel;
	
	public Window(String title, int x, int y) {
		this.title = title;
		this.x = x;
		this.y = y;
		this.panel = new Panel();
		
		this.setTitle(title);
		this.setSize(x, y);
		this.setContentPane(this.panel);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void addButton(Button button) {
		Panel pan = this.panel;
		pan.add(button);
		this.setContentPane(pan);
	}
	
	public void addText(Text text) {
		Panel pan = this.panel;
		pan.add(text);
		this.setContentPane(pan);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
