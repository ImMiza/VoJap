package me.ressources.mode.wordgestion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import me.main.VoMain;
import me.ressources.Kanji;

public class ListKanji {

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	public ListKanji(String title, int width, int height) {
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
		this.panel.setLayout(new GridLayout(VoMain.getDictionnary().getKanjis().size() + 2, 3));
		
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
		
		JLabel title3 = new JLabel("Kanji");
		title3.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		title3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		title3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel word = new JLabel("Nombre de kanji");
		word.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		word.setAlignmentX(Component.LEFT_ALIGNMENT);
		word.setHorizontalAlignment(SwingConstants.CENTER);
		word.setForeground(Color.BLUE);
		
		JLabel sizeWord = new JLabel("" + VoMain.getDictionnary().getKanjis().size());
		sizeWord.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		sizeWord.setAlignmentX(Component.LEFT_ALIGNMENT);
		sizeWord.setHorizontalAlignment(SwingConstants.CENTER);
		sizeWord.setForeground(Color.BLUE);
		
		this.panel.add(title1);
		this.panel.add(title2);
		this.panel.add(title3);
		
		this.panel.add(word);
		this.panel.add(sizeWord);
		this.panel.add(Box.createHorizontalGlue());

		for (Kanji k : VoMain.getDictionnary().getKanjis()) {
			
			JLabel french = new JLabel(k.getFrenchWord());
			french.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			french.setAlignmentX(Component.LEFT_ALIGNMENT);
			french.setMaximumSize(new Dimension(width / 2, height / 15));
			french.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel japanese = new JLabel(k.getHiraganaWord());
			japanese.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			japanese.setAlignmentX(Component.RIGHT_ALIGNMENT);
			japanese.setMaximumSize(new Dimension(width / 2, height / 15));
			japanese.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel kanji = new JLabel(k.getKanjiWord());
			kanji.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			kanji.setAlignmentX(Component.RIGHT_ALIGNMENT);
			kanji.setMaximumSize(new Dimension(width / 2, height / 15));
			kanji.setHorizontalAlignment(SwingConstants.CENTER);
			
			this.panel.add(french);
			this.panel.add(japanese);
			this.panel.add(kanji);
		}
		
		scroll.add(panel);
		this.window.setContentPane(scroll);
	}
	
	
	
}
