package me.ressources.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.WindowConstants;

import me.main.VoMain;
import me.ressources.Word;

public abstract class WindowGestion {

	private static Window window;
	private static int width;
	private static int height;
	private static String title;
	private static Panel panel;
	
	private static Text trainingText;
	private static String trainingAnswer;
	private static Panel trainingPanel;
	private static TextField trainingField;
	private static ArrayList<Word> words;
	private static int scorePlus;
	private static int scoreMoins;
	private static Text trainingIndicator;
	
	static {
		title = "VoJap (Beta)";
		width = 800;
		height = 400;
		panel = new Panel();
	}

	public static void openIndexWindow() {
		window = new Window(title, width, height);

		Text text = new Text("VoJap !");
		Text text2 = new Text("Apprend ton Japonais !");

		text.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		text2.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		text2.setAlignmentX(Component.CENTER_ALIGNMENT);

		Button addWord = new Button("Ajouter du vocabulaire", new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				addWord();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		addWord.setAlignmentX(Component.CENTER_ALIGNMENT);

		Button removeWord = new Button("supprimer du vocabulaire", new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				removeWord();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		removeWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Button list = new Button("Liste du Vocabulaire", new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				list();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		list.setAlignmentX(Component.CENTER_ALIGNMENT);

		Button clearList = new Button("Reset la liste", new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				clearlist();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		clearList.setAlignmentX(Component.CENTER_ALIGNMENT);

		Button training = new Button("Entrainement", new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				training();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		training.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(text);
		panel.add(text2);
		panel.add(addWord);
		panel.add(removeWord);
		panel.add(list);
		panel.add(clearList);
		panel.add(training);

		window.setContentPane(panel);
	}

	public static void addWord() {
		Window win = new Window("Vocabulaire", (int) (width / 1.2), (int) (height / 1.2));
		win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Panel pan = new Panel();

		Text french = new Text("Mot francais");
		Text japanese = new Text("Mot Japonais");
		TextField frenchField = new TextField();
		TextField japaneseField = new TextField();
		Button valid = new Button("Valider", new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (frenchField.getText().equals("") || japaneseField.getText().equals("")) {
					Text warning = new Text("Champ vide !");
					warning.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
					warning.setAlignmentX(Component.CENTER_ALIGNMENT);
					warning.setForeground(Color.RED);
					pan.add(warning);
					win.setContentPane(pan);
				} else {
					Word word = new Word(frenchField.getText(), japaneseField.getText());
					VoMain.getDictionnary().addWord(word);
					VoMain.getDictionnary().save(VoMain.getFile());
					win.dispose();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		Panel l1 = new Panel();
		l1.setLayout(new BoxLayout(l1, BoxLayout.LINE_AXIS));
		l1.add(french);
		l1.add(frenchField);

		Panel l2 = new Panel();
		l2.setLayout(new BoxLayout(l2, BoxLayout.LINE_AXIS));
		l2.add(japanese);
		l2.add(japaneseField);

		Panel l3 = new Panel();
		l3.setLayout(new BoxLayout(l3, BoxLayout.LINE_AXIS));
		l3.add(valid);

		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		pan.add(l1);
		pan.add(l2);
		pan.add(l3);

		win.setContentPane(pan);
	}

	public static void list() {
		Window win = new Window("Liste de vocabulaire", (int) (width / 2), (int) (height / 1.2));
		win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Panel pan = new Panel();
		Panel lw = new Panel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));

		Text text1 = new Text("Francais");
		text1.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		Text text2 = new Text("Japonais");
		text2.setFont(new Font(Font.SERIF, Font.BOLD, 30));

		lw.setLayout(new BoxLayout(lw, BoxLayout.LINE_AXIS));
		lw.add(text1);
		lw.add(Box.createHorizontalStrut(30));
		lw.add(text2);
		pan.add(lw);

		for (Word w : VoMain.getDictionnary().getWords()) {
			lw = new Panel();

			Text french = new Text(w.getFrenchWord());
			Text japanese = new Text(w.getJapaneseWord());

			lw.setLayout(new BoxLayout(lw, BoxLayout.LINE_AXIS));
			lw.add(french);
			lw.add(Box.createHorizontalStrut(30));
			lw.add(japanese);

			pan.add(lw);
		}

		pan.setAlignmentX(Component.CENTER_ALIGNMENT);
		pan.setPreferredSize(new Dimension((int) (width / 2), (int) (height / 1.2)));
		win.setContentPane(pan);
	}

	public static void clearlist() {
		Window win = new Window("Liste de vocabulaire", (int) (width / 3), (int) (height / 3));
		win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Panel pan = new Panel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));

		Text text = new Text("Vous etes sur ?");

		Button yes = new Button("oui", new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				VoMain.getDictionnary().getWords().clear();
				if (VoMain.getFile().exists())
					VoMain.getFile().delete();
				win.dispose();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		yes.setAlignmentX(Component.CENTER_ALIGNMENT);

		Button no = new Button("non", new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				win.dispose();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		no.setAlignmentX(Component.CENTER_ALIGNMENT);

		pan.add(text);
		pan.add(yes);
		pan.add(no);
		pan.setAlignmentX(Component.CENTER_ALIGNMENT);

		win.setContentPane(pan);
	}

	@SuppressWarnings("unchecked")
	public static void training() {
		Window win = new Window("Entrainement", width, height);
		win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		trainingField = new TextField();
		words = (ArrayList<Word>) VoMain.getDictionnary().getWords().clone();
		scorePlus = 0;
		scoreMoins = 0;
		trainingIndicator = new Text("");
		
		Collections.shuffle(words);
		Word w = words.get(0);

		trainingPanel = new Panel();
		trainingPanel.setLayout(new BoxLayout(trainingPanel, BoxLayout.PAGE_AXIS));
		
		if(Math.random() < 0.5) {
			trainingText = new Text(w.getFrenchWord());
			trainingAnswer = w.getJapaneseWord();
		}
		else {
			trainingText = new Text(w.getJapaneseWord());
			trainingAnswer = w.getFrenchWord();
		}
		trainingField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			@Override
			public void keyPressed(KeyEvent key) {
				if(key.getKeyCode() == KeyEvent.VK_ENTER) {
					if(words.size() > 1) {
						if(trainingField.getText().equals(trainingAnswer)) {
							words.remove(0);
							scorePlus += 1;
							trainingIndicator.setText("Correct !");
							trainingIndicator.setForeground(Color.GREEN);
						}
						else
						{
							scoreMoins += 1;
							trainingIndicator.setText("Faux ! Réponse: " + trainingAnswer);
							trainingIndicator.setForeground(Color.RED);
						}
						
						Collections.shuffle(words);
						Word w = words.get(0);
						
						if(Math.random() < 0.5) {
							trainingText.setText(w.getFrenchWord());
							trainingAnswer = w.getJapaneseWord();
						}
						else {
							trainingText.setText(w.getJapaneseWord());
							trainingAnswer = w.getFrenchWord();
						}
						trainingField.setText("");
						panel.repaint();
						
						
					}
					else {
						if(trainingField.getText().equals(trainingAnswer)) {
							words.remove(0);
							scorePlus += 1;
							win.dispose();
							result();
						}
						else {
							scoreMoins += 1;
							
							if(Math.random() < 0.5) {
								trainingText.setText(w.getFrenchWord());
								trainingAnswer = w.getJapaneseWord();
							}
							else {
								trainingText.setText(w.getJapaneseWord());
								trainingAnswer = w.getFrenchWord();
							}
							trainingField.setText("");
							panel.repaint();
						}
						
					}
					
					
				}
			}
		});
		
		trainingText.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		trainingText.setAlignmentX(Component.CENTER_ALIGNMENT);
		trainingIndicator.setAlignmentX(Component.CENTER_ALIGNMENT);
		trainingIndicator.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		
		trainingPanel.add(trainingText);
		trainingPanel.add(Box.createVerticalStrut(60));
		trainingPanel.add(trainingField);
		trainingPanel.add(trainingIndicator);
		win.setContentPane(trainingPanel);

	}
	
	private static void result() {
		Window win = new Window("resultat", width / 2, height / 2);
		win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Panel pan = new Panel();
		Text result = new Text("Resultat");
		Text tsPlus = new Text("Reussi: " + scorePlus);
		Text tsMoins = new Text("Echoue: " + scoreMoins);
		
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		
		result.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		result.setAlignmentX(Component.CENTER_ALIGNMENT);
		tsPlus.setAlignmentX(Component.CENTER_ALIGNMENT);
		tsMoins.setAlignmentX(Component.CENTER_ALIGNMENT);

		pan.add(result);
		pan.add(Box.createVerticalStrut(60));
		pan.add(tsPlus);
		pan.add(Box.createVerticalStrut(20));
		pan.add(tsMoins);
		
		win.setContentPane(pan);
		
	}
	
	public static void removeWord() {
		Window win = new Window("resultat", width / 3, height / 3);
		win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Panel pan = new Panel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		Text text = new Text("Entrez le mot francais ou japonais:");
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		Text unfound = new Text("");
		unfound.setAlignmentX(Component.CENTER_ALIGNMENT);
		TextField field = new TextField();
		field.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e)
			{}
			
			@Override
			public void keyReleased(KeyEvent e)
			{}
			
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					if(VoMain.getDictionnary().containsWord(field.getText())) {
						VoMain.getDictionnary().removeWord(field.getText());
						win.dispose();
					}
					else {
						unfound.setText("Mot introuvable");
						unfound.setForeground(Color.RED);
						win.repaint();
					}
				}
			}
		});
		
		pan.add(text);
		pan.add(field);
		pan.add(unfound);
		win.setContentPane(pan);
		
		
	}
	
}
