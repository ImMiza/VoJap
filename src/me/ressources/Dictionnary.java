package me.ressources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionnary {

	private ArrayList<Word> words;

	public Dictionnary() {
		this.words = new ArrayList<Word>();
	}

	public void addWord(Word w) {
		this.words.add(w);
	}

	public void addWord(String french, String japanese) {
		Word w = new Word(french, japanese);
		this.words.add(w);
	}

	public void removeWord(Word w) {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getFrenchWord().equals(w.getFrenchWord())
					|| words.get(i).getJapaneseWord().equals(w.getJapaneseWord())) {
				words.remove(i);
			}
		}
	}

	public void removeWord(String word) {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getFrenchWord().equals(word) || words.get(i).getJapaneseWord().equals(word)) {
				words.remove(i);
			}
		}
	}

	public boolean containsWord(String word) {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getFrenchWord().equals(word) || words.get(i).getJapaneseWord().equals(word)) {
				return true;
			}
		}

		return false;
	}

	public ArrayList<Word> getWords() {
		return words;
	}

	public void setWords(ArrayList<Word> words) {
		this.words = words;
	}

	public void save(File file) {
		if (file.exists())
			file.delete();

		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Impossible de creer le fichier !");
			e.printStackTrace();
		}
		file.setWritable(true);

		try {
			BufferedWriter write = new BufferedWriter(new FileWriter(file));
			for (Word word : this.words) {
				write.write(word.getFrenchWord() + ":" + word.getJapaneseWord() + "\n");
				write.flush();
			}
			write.newLine();
			write.close();
		} catch (IOException e) {
			System.err.println("Impossible d'ouvrir un Buffer d'ecriture !");
			e.printStackTrace();
		}

		file.setWritable(false);
	}

	public void load(File file) {
		if (file.exists()) {
			try {
				BufferedReader read = new BufferedReader(new FileReader(file));
				String line = read.readLine();
				Word word = null;
				while (line != null) {
					String[] t = line.split(":");
					word = new Word(t[0], t[1]);
					this.words.add(word);
					line = read.readLine();
				}
				read.close();
			} catch (IOException e) {
				System.err.println("Impossible d'ouvrir un Buffer de lecture !");
				e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e) {}
		} else {
			System.err.println("Impossible de load le fichier !");
		}
	}

}
