package me.ressources.mode;

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

import me.main.VoMain;
import me.ressources.mode.wordgestion.AddWordIndex;
import me.ressources.mode.wordgestion.ClearList;
import me.ressources.mode.wordgestion.ListIndex;
import me.ressources.mode.wordgestion.RemoveWord;
import me.ressources.mode.wordgestion.TrainingIndex;

public class Index {

	private JFrame window;
	private JPanel panel;
	private String title;
	private int defaultWidth;
	private int defaultHeight;
	
	public Index(String title, int width, int height) {
		this.title = title;
		this.defaultWidth = width;
		this.defaultHeight = height;
		
		panel = new JPanel();
		this.panel.setBackground(Color.LIGHT_GRAY);
		
		window = new JFrame(this.title);
		this.window.setTitle(title);
		this.window.setSize(this.defaultWidth, this.defaultHeight);
		this.window.setMinimumSize(new Dimension(width / 5, height));
		this.window.setContentPane(this.panel);
		this.window.setLocationRelativeTo(null);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setVisible(true);
		
		JLabel text = new JLabel("VoJap !");
		text.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel text2 = new JLabel("Apprend ton Japonais !");
		text2.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
		text2.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton addWord = initializeAddWord();
		addWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		addWord.setBackground(Color.DARK_GRAY);
		addWord.setForeground(Color.WHITE);
		addWord.setMaximumSize(new Dimension(width / 2, height / 10));
		
		JButton removeWord = initializeRemoveWord();
		removeWord.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeWord.setMaximumSize(new Dimension(width / 2, height / 10));
		removeWord.setBackground(Color.DARK_GRAY);
		removeWord.setForeground(Color.WHITE);
		
		JButton list = initializeList();
		list.setAlignmentX(Component.CENTER_ALIGNMENT);
		list.setMaximumSize(new Dimension(width / 2, height / 10));
		list.setBackground(Color.DARK_GRAY);
		list.setForeground(Color.WHITE);
		
		JButton clearList = initializeClearList();
		clearList.setAlignmentX(Component.CENTER_ALIGNMENT);
		clearList.setMaximumSize(new Dimension(width / 2, height / 10));
		clearList.setBackground(Color.DARK_GRAY);
		clearList.setForeground(Color.WHITE);
		
		JButton training = initializeTraining();
		training.setAlignmentX(Component.CENTER_ALIGNMENT);
		training.setMaximumSize(new Dimension(width / 2, height / 10));
		training.setBackground(Color.DARK_GRAY);
		training.setForeground(Color.WHITE);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(text);
		panel.add(text2);
		panel.add(Box.createVerticalStrut(20));
		panel.add(addWord);
		panel.add(Box.createVerticalStrut(8));
		panel.add(removeWord);
		panel.add(Box.createVerticalStrut(8));
		panel.add(list);
		panel.add(Box.createVerticalStrut(8));
		panel.add(clearList);
		panel.add(Box.createVerticalStrut(8));
		panel.add(training);

		this.window.setContentPane(panel);
	}
	
	private JButton initializeAddWord() {
		JButton addWord = new JButton("Ajouter du vocabulaire");
		addWord.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new AddWordIndex(title, (defaultWidth / 2), (defaultHeight / 2));
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		return addWord;
	}
	
	private JButton initializeRemoveWord() {
		JButton removeWord = new JButton("supprimer du vocabulaire");
		removeWord.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new RemoveWord(title, (defaultWidth / 2), (defaultHeight / 4));
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		return removeWord;
	}
	
	private JButton initializeList() {
		JButton list = new JButton("liste du vocabulaire");
		list.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new ListIndex("List", (defaultWidth / 2), defaultHeight / 2);
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		return list;
	}
	
	private JButton initializeClearList() {
		JButton clearList = new JButton("reset la liste");
		clearList.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				new ClearList(title, (defaultWidth / 3), (defaultHeight / 3));
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		return clearList;
	}
	
	private JButton initializeTraining() {
		JButton training = new JButton("entrainement");
		training.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				if(!VoMain.getDictionnary().getWords().isEmpty())
					new TrainingIndex("Entrainement", defaultWidth, defaultHeight / 2);
				else
					System.err.println("Liste vide !");
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		return training;
	}
}
