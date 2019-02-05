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


public class AddWordIndex
{

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	public AddWordIndex(String title, int width, int height)
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
		
		JLabel text = new JLabel("Ajout de vocabulaire");
		text.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton addWord = initializeWord();
		addWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		addWord.setBackground(Color.DARK_GRAY);
		addWord.setForeground(Color.WHITE);
		addWord.setMaximumSize(new Dimension((int) (width / 1.5), height / 5));
		
		JButton addKanjiWord = initializeKanjiWord();
		addKanjiWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		addKanjiWord.setBackground(Color.DARK_GRAY);
		addKanjiWord.setForeground(Color.WHITE);
		addKanjiWord.setMaximumSize(new Dimension((int) (width / 1.5), height / 5));
		
		this.panel.add(text);
		this.panel.add(Box.createVerticalStrut(10));
		this.panel.add(addWord);
		this.panel.add(Box.createVerticalStrut(10));
		this.panel.add(addKanjiWord);
		
		this.window.setContentPane(this.panel);
	}
	
	private JButton initializeWord() {
		JButton NormalMode = new JButton("Ajouter mot de vocabulaire");
		NormalMode.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new AddWord(title, (VoMain.defaultWidth / 2), (VoMain.defaultHeight / 2));
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
	
	private JButton initializeKanjiWord() {
		JButton wordBox = new JButton("Ajouter Kanji");
		wordBox.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new AddKanjiWord(title, (VoMain.defaultWidth / 2), (VoMain.defaultHeight / 2));
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
