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
import me.ressources.mode.wordgestion.gamemode.Normal;
import me.ressources.mode.wordgestion.gamemode.WordsBox;


public class TrainingIndex
{

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	public TrainingIndex(String title, int width, int height)
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
		
		JLabel text = new JLabel("Mode d'entrainement");
		text.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton NormalMode = initializeNormalMode();
		NormalMode.setAlignmentX(Component.CENTER_ALIGNMENT);
		NormalMode.setBackground(Color.DARK_GRAY);
		NormalMode.setForeground(Color.WHITE);
		NormalMode.setMaximumSize(new Dimension(width / 2, height / 5));
		
		JButton wordsBoxMode = initializeWordsBoxMode();
		wordsBoxMode.setAlignmentX(Component.CENTER_ALIGNMENT);
		wordsBoxMode.setBackground(Color.DARK_GRAY);
		wordsBoxMode.setForeground(Color.WHITE);
		wordsBoxMode.setMaximumSize(new Dimension(width / 2, height / 5));
		
		this.panel.add(text);
		this.panel.add(Box.createVerticalStrut(10));
		this.panel.add(NormalMode);
		this.panel.add(Box.createVerticalStrut(10));
		this.panel.add(wordsBoxMode);
		
		this.window.setContentPane(this.panel);
	}
	
	private JButton initializeNormalMode() {
		JButton NormalMode = new JButton("Mode normal");
		NormalMode.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new Normal("Entrainement", VoMain.getDefaultWidth(), (int) (VoMain.getDefaultHeight() / 1.5));
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
	
	private JButton initializeWordsBoxMode() {
		JButton wordBox = new JButton("Pyramide de mot");
		wordBox.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new WordsBox("Entrainement", VoMain.getDefaultWidth(), (int) (VoMain.getDefaultHeight() / 1.5));
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
