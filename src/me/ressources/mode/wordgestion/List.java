package me.ressources.mode.wordgestion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import me.main.VoMain;
import me.ressources.Word;

public class List {

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	public List(String title, int width, int height) {
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
		this.panel.setLayout(new GridLayout(VoMain.getDictionnary().getWords().size() + 2, 2));
		
		ScrollPane scroll = new ScrollPane();
		scroll.getVAdjustable().setUnitIncrement(20);
		
		JLabel title1 = new JLabel("Francais");
		title1.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		title1.setAlignmentX(Component.LEFT_ALIGNMENT);
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel title2 = new JLabel("Japonais");
		title2.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		title2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel word = new JLabel("Nombre de mot");
		word.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		word.setAlignmentX(Component.LEFT_ALIGNMENT);
		word.setHorizontalAlignment(SwingConstants.CENTER);
		word.setForeground(Color.BLUE);
		
		JLabel sizeWord = new JLabel("" + VoMain.getDictionnary().getWords().size());
		sizeWord.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		sizeWord.setAlignmentX(Component.LEFT_ALIGNMENT);
		sizeWord.setHorizontalAlignment(SwingConstants.CENTER);
		sizeWord.setForeground(Color.BLUE);
		
		this.panel.add(title1);
		this.panel.add(title2);
		this.panel.add(word);
		this.panel.add(sizeWord);

		for (Word w : VoMain.getDictionnary().getWords()) {
			
			JLabel french = new JLabel(w.getFrenchWord());
			french.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			french.setAlignmentX(Component.LEFT_ALIGNMENT);
			french.setMaximumSize(new Dimension(width / 2, height / 15));
			french.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel japanese = new JLabel(w.getJapaneseWord());
			japanese.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			japanese.setAlignmentX(Component.RIGHT_ALIGNMENT);
			japanese.setMaximumSize(new Dimension(width / 2, height / 15));
			japanese.setHorizontalAlignment(SwingConstants.CENTER);
			
			this.panel.add(french);
			this.panel.add(japanese);
		}
		
		scroll.add(panel);
		this.window.setContentPane(scroll);
	}
	
}
