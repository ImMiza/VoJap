package me.ressources.mode.wordgestion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import me.main.VoMain;

public class RemoveWord {

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	public RemoveWord(String title, int width, int height) {
		this.title = title;
		this.defaultWidth = width;
		this.defaultHeight = height;
		
		this.window = new JFrame(this.title);
		this.window.setSize(this.defaultWidth, this.defaultHeight);
		this.window.setLocationRelativeTo(null);
		this.window.setAlwaysOnTop(true);
		this.window.setVisible(true);
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.PAGE_AXIS));
		
		JLabel text = new JLabel("Entrez le mot francais ou japonais:");
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		text.setMaximumSize(new Dimension(width, height / 8));
		text.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 15));
		
		JLabel unfound = new JLabel("");
		unfound.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		TextField field = initializefield(unfound);
		field.setMaximumSize(new Dimension(width, height / 8));
		field.setFont(new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 20));
		
		this.panel.add(text);
		this.panel.add(Box.createHorizontalStrut(1));
		this.panel.add(field);
		this.panel.add(unfound);
		this.window.setContentPane(this.panel);
	}
	
	private TextField initializefield(JLabel unfound) {
		TextField field = new TextField();
		field.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e){}
			@Override
			public void keyReleased(KeyEvent e){}
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					if(VoMain.getDictionnary().containsWord(field.getText())) {
						VoMain.getDictionnary().removeWord(field.getText());
						window.dispose();
					}
					else {
						unfound.setText("Mot introuvable");
						unfound.setForeground(Color.RED);
						window.repaint();
					}
				}
			}
		});
		
		return field;
	}
}
