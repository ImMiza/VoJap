package me.ressources.mode.wordgestion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
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
import me.ressources.Kanji;

public class AddKanjiWord {

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	public AddKanjiWord(String title, int width, int height) {
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
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		JLabel french = new JLabel("Mot francais");
		JLabel japanese = new JLabel("Mot Japonais");
		JLabel kanji = new JLabel("Mot kanji");
		
		JLabel warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
		warning.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		TextField frenchField = new TextField();
		frenchField.setMaximumSize(new Dimension(width, height / 5));
		frenchField.setFont(new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 20));
		
		TextField japaneseField = new TextField();
		japaneseField.setMaximumSize(new Dimension(width, height / 5));
		japaneseField.setFont(new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 20));
		
		TextField kanjiField = new TextField();
		kanjiField.setMaximumSize(new Dimension(width, height / 5));
		kanjiField.setFont(new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 20));
		
		JButton valid = initializeValid(frenchField, japaneseField, kanjiField, warning);
		valid.setAlignmentX(Component.CENTER_ALIGNMENT);
		valid.setBackground(Color.DARK_GRAY);
		valid.setForeground(Color.WHITE);
		valid.setMaximumSize(new Dimension(width / 2, height / 6));
		
		JPanel l1 = new JPanel();
		l1.setLayout(new BoxLayout(l1, BoxLayout.LINE_AXIS));
		l1.add(kanji);
		l1.add(kanjiField);
		
		JPanel l2 = new JPanel();
		l2.setLayout(new BoxLayout(l2, BoxLayout.LINE_AXIS));
		l2.add(japanese);
		l2.add(japaneseField);
		
		JPanel l3 = new JPanel();
		l3.setLayout(new BoxLayout(l3, BoxLayout.LINE_AXIS));
		l3.add(french);
		l3.add(frenchField);
		
		this.panel.add(l1);
		this.panel.add(Box.createVerticalStrut(5));
		this.panel.add(l2);
		this.panel.add(Box.createVerticalStrut(5));
		this.panel.add(l3);
		this.panel.add(Box.createVerticalStrut(20));
		this.panel.add(valid);
		this.panel.add(warning);
		
		this.window.setContentPane(this.panel);
	}
	
	
	private JButton initializeValid(TextField frenchField, TextField japaneseField, TextField kanjiField, JLabel warning) {
		JButton valid = new JButton("Valider");
		valid.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				if (frenchField.getText().equals("") || japaneseField.getText().equals("")) {
					warning.setText("Champ vide !");
					window.repaint();
					
				} else {
					Kanji word = new Kanji(frenchField.getText(), japaneseField.getText(), kanjiField.getText());
					VoMain.getDictionnary().addWord(word);
					VoMain.getDictionnary().save(VoMain.getFile());
					window.dispose();
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		return valid;
	}
}
