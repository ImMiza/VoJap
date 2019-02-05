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


public class ListIndex
{

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	public ListIndex(String title, int width, int height)
	{
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
		
		JLabel text = new JLabel("Liste du vocabulaire");
		text.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton list = initializeList();
		list.setAlignmentX(Component.CENTER_ALIGNMENT);
		list.setBackground(Color.DARK_GRAY);
		list.setForeground(Color.WHITE);
		list.setMaximumSize(new Dimension((int) (width / 1.5), height / 5));
		
		JButton listKanji = initializeKanjiList();
		listKanji.setAlignmentX(Component.CENTER_ALIGNMENT);
		listKanji.setBackground(Color.DARK_GRAY);
		listKanji.setForeground(Color.WHITE);
		listKanji.setMaximumSize(new Dimension((int) (width / 1.5), height / 5));
		
		this.panel.add(text);
		this.panel.add(Box.createVerticalStrut(10));
		this.panel.add(list);
		this.panel.add(Box.createVerticalStrut(10));
		this.panel.add(listKanji);
		
		this.window.setContentPane(this.panel);
	}
	
	private JButton initializeList() {
		JButton NormalMode = new JButton("Liste vocabulaire");
		NormalMode.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new List("List", (VoMain.defaultWidth / 2), VoMain.defaultHeight);
				window.dispose();
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		return NormalMode;
	}
	
	private JButton initializeKanjiList() {
		JButton wordBox = new JButton("Liste des Kanji");
		wordBox.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new ListKanji(title, (int) (VoMain.defaultWidth / 1.5), (VoMain.defaultHeight / 2));
				window.dispose();
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		return wordBox;
	}
}
