package me.ressources.mode.wordgestion.gamemode;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import me.main.VoMain;
import me.ressources.Word;

public class Normal
{

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	private int erreur;
	private JLabel word;
	private JLabel sizeWord;
	private String answer;
	
	private ArrayList<Error> errors;
	
	public Normal(String title, int width, int height)
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
		
		this.word = new JLabel("");
		this.word.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		this.word.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.answer = "";
		
		this.errors = new ArrayList<Error>();
		
		@SuppressWarnings("unchecked")
		final ArrayList<Word> words = (ArrayList<Word>) VoMain.getDictionnary().getWords().clone();
		Collections.shuffle(words);
		
		this.sizeWord = new JLabel("mot(s) restant(s): " + words.size());
		this.sizeWord.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 10));
		this.sizeWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.erreur = 0;
		
		final JLabel indicator = new JLabel("");
		indicator.setAlignmentX(Component.CENTER_ALIGNMENT);
		indicator.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		
		Word w = words.get(0);
		random(w);
		
		final TextField field = new TextField();
		field.setMaximumSize(new Dimension(width, height / 4));
		field.setFont(new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 20));
		field.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			@Override
			public void keyPressed(KeyEvent key) {
				if(key.getKeyCode() == KeyEvent.VK_ENTER) {
					words.remove(0);
					if(field.getText().equals(answer)) {
						indicator.setText("Correct !");
						indicator.setForeground(Color.GREEN);
					}
					else
					{
						erreur += 1;
						Error e = new Error(word.getText(), field.getText(), answer);
						errors.add(e);
						indicator.setText("Faux ! Réponse: " + answer);
						indicator.setForeground(Color.RED);
					}
					
					if(words.size() == 0) {
						window.dispose();
						result("Résultat", height, height);
					}
					else {
						Collections.shuffle(words);
						Word w = words.get(0);
						random(w);
						field.setText("");
						sizeWord.setText("mot(s) restant(s): " + words.size());
						panel.repaint();
					}
					
				}
			}
		});
		
		this.panel.add(this.word);
		this.panel.add(Box.createVerticalStrut(10));
		this.panel.add(this.sizeWord);
		this.panel.add(Box.createVerticalStrut(40));
		this.panel.add(field);
		this.panel.add(indicator);
		this.window.setContentPane(this.panel);
	}
	
	private void random(Word w) {
		if(Math.random() < 0.5) {
			this.word.setText(w.getFrenchWord());
			this.answer = w.getJapaneseWord();
		}
		else {
			this.word.setText(w.getJapaneseWord());
			this.answer = w.getFrenchWord();
		}
	}
	
	private void result(String title, int width, int height) {
		JFrame windowResult = new JFrame(title);
		windowResult.setSize(this.defaultWidth, this.defaultHeight);
		windowResult.setContentPane(this.panel);
		windowResult.setLocationRelativeTo(null);
		windowResult.setVisible(true);
		windowResult.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		
		JLabel result = new JLabel("Resultat");
		result.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		result.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel tsPlus = new JLabel("Nombre de mot: " + VoMain.getDictionnary().getWords().size());
		tsPlus.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel tsMoins = new JLabel("Nombre d'erreur: " + this.erreur);
		tsMoins.setAlignmentX(Component.CENTER_ALIGNMENT);

		pan.add(result);
		pan.add(Box.createVerticalStrut(60));
		pan.add(tsPlus);
		pan.add(Box.createVerticalStrut(20));
		pan.add(tsMoins);
		pan.add(Box.createVerticalStrut(20));
		
		for(Error error : this.errors) {
			JLabel question = new JLabel("Le mot: " + error.getQuestion());
			question.setAlignmentX(Component.CENTER_ALIGNMENT);
			question.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 20));
			question.setForeground(Color.ORANGE);
			
			JLabel answerUser = new JLabel("Votre réponse: " + error.getAnswerOnUser());
			answerUser.setAlignmentX(Component.CENTER_ALIGNMENT);
			answerUser.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 20));
			answerUser.setForeground(Color.RED);
			
			JLabel trueAnswer = new JLabel("La réponse: " + error.getTrueAnswer());
			trueAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
			trueAnswer.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 20));
			trueAnswer.setForeground(Color.GREEN);
			
			pan.add(question);
			pan.add(answerUser);
			pan.add(trueAnswer);
			pan.add(Box.createVerticalStrut(20));
		}
		
		ScrollPane scroll = new ScrollPane();
		scroll.getVAdjustable().setUnitIncrement(20);
		scroll.add(pan);
		
		windowResult.setContentPane(scroll);
	}
}
