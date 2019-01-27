package me.ressources.mode.wordgestion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import me.main.VoMain;

public class ClearList {

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	public ClearList(String title, int width, int height) {
		this.title = title;
		this.defaultWidth = width;
		this.defaultHeight = height;
		
		this.window = new JFrame(this.title);
		this.window.setSize(this.defaultWidth, this.defaultHeight);
		this.window.setAlwaysOnTop(true);
		this.window.setLocationRelativeTo(null);
		this.window.setVisible(true);
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.PAGE_AXIS));

		JLabel text = new JLabel("Vous êtes sur ?");
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		text.setFont(new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 15));
		
		JButton yes = initializeYes();
		yes.setAlignmentX(Component.CENTER_ALIGNMENT);
		yes.setMaximumSize(new Dimension(width / 2, height / 5));
		yes.setBackground(Color.DARK_GRAY);
		yes.setForeground(Color.WHITE);
		
		JButton no = initializeNo();
		no.setAlignmentX(Component.CENTER_ALIGNMENT);
		no.setMaximumSize(new Dimension(width / 2, height / 5));
		no.setBackground(Color.DARK_GRAY);
		no.setForeground(Color.WHITE);
		
		this.panel.add(text);
		this.panel.add(Box.createVerticalStrut(10));
		this.panel.add(yes);
		this.panel.add(Box.createVerticalStrut(5));
		this.panel.add(no);

		this.window.setContentPane(this.panel);
	}
	
	private JButton initializeYes() {
		JButton yes = new JButton("oui");
		yes.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				VoMain.getDictionnary().getWords().clear();
				if (VoMain.getFile().exists())
					VoMain.getFile().delete();
				window.dispose();
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		return yes;
	}
	
	private JButton initializeNo() {
		JButton no = new JButton("non");
		no.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				window.dispose();
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		return no;
	}
}
