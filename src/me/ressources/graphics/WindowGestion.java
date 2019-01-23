package me.ressources.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.WindowConstants;

import me.main.VoMain;
import me.ressources.Word;

public abstract class WindowGestion
{

	private static Window window;
	private static int width;
	private static int height;
	private static String title;
	private static Panel panel;
	
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
		
		text.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		text2.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		text2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Button addWord = new Button("Ajouter du vocabulaire", new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e){}
			@Override
			public void mousePressed(MouseEvent e)
			{
				addWord();
			}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}
		});
		addWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Button list = new Button("Liste du Vocabulaire", new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e){}
			@Override
			public void mousePressed(MouseEvent e)
			{
				list();
			}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}
		});
		list.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Button clearList = new Button("Reset la liste", new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e){}
			@Override
			public void mousePressed(MouseEvent e)
			{
				clearlist();
			}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}
		});
		clearList.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Button training = new Button("Entrainement", new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e){}
			@Override
			public void mousePressed(MouseEvent e)
			{
				System.out.println("ENTRAINEMENT");
			}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}
		});
		training.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(text);
		panel.add(text2);
		panel.add(addWord);
		panel.add(list);
		panel.add(clearList);
		panel.add(training);
		
		window.setContentPane(panel);
	}
	
	private static void addWord() {
		Window win = new Window("Vocabulaire", (int) (width / 1.2), (int) (height / 1.2));
		win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Panel pan = new Panel();
		
		Text french = new Text("Mot francais");
		Text japanese = new Text("Mot Japonais");
		TextField frenchField = new TextField();
		TextField japaneseField = new TextField();
		Button valid = new Button("Valider", new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e){}
			@Override
			public void mousePressed(MouseEvent e)
			{
				if(frenchField.getText().equals("") || japaneseField.getText().equals("")) {
					Text warning = new Text("Champ vide !");
					warning.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
					warning.setAlignmentX(Component.CENTER_ALIGNMENT);
					warning.setForeground(Color.RED);
					pan.add(warning);
					win.setContentPane(pan);
				}
				else {
					Word word = new Word(frenchField.getText(), japaneseField.getText());
					VoMain.getDictionnary().addWord(word);
					VoMain.getDictionnary().save(VoMain.getFile());
					win.dispose();
				}
			}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}
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
	
	
	private static void list() {
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
		
		for(Word w : VoMain.getDictionnary().getWords()) {
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
	
	private static void clearlist() {
		Window win = new Window("Liste de vocabulaire", (int) (width / 3), (int) (height / 3));
		win.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Panel pan = new Panel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
		
		Text text = new Text("Vous etes sur ?");
		
		Button yes = new Button("oui", new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e){}
			@Override
			public void mousePressed(MouseEvent e)
			{
				VoMain.getDictionnary().getWords().clear();
				if(VoMain.getFile().exists())
					VoMain.getFile().delete();
				win.dispose();
			}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}
		});
		yes.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Button no = new Button("non", new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e){}
			@Override
			public void mousePressed(MouseEvent e)
			{
				win.dispose();
			}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}
		});
		no.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		pan.add(text);
		pan.add(yes);
		pan.add(no);
		pan.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		win.setContentPane(pan);
	}
}
