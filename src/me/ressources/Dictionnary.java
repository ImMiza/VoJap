package me.ressources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;


public class Dictionnary {

	private ArrayList<Word> words;
	private ArrayList<Kanji> kanjis;

	public Dictionnary() {
		this.words = new ArrayList<Word>();
		this.kanjis = new ArrayList<Kanji>();
	}

	public void addWord(Word w) {
		this.words.add(w);
	}
	
	public void addWord(Kanji k) {
		this.kanjis.add(k);
	}

	public void removeWord(Word w) {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getFrenchWord().equals(w.getFrenchWord())
					|| words.get(i).getJapaneseWord().equals(w.getJapaneseWord())) {
				words.remove(i);
			}
		}
	}
	
	public void removeKanji(Kanji k) {
		for (int i = 0; i < kanjis.size(); i++) {
			if (kanjis.get(i).getFrenchWord().equals(k.getFrenchWord()) || kanjis.get(i).getHiraganaWord().equals(k.getHiraganaWord()) || kanjis.get(i).getKanjiWord().equals(k.getKanjiWord())) {
				kanjis.remove(i);
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
	
	public void removeKanji(String kanji) {
		for (int i = 0; i < kanjis.size(); i++) {
			if (kanjis.get(i).getFrenchWord().equals(kanji) || kanjis.get(i).getHiraganaWord().equals(kanji) || kanjis.get(i).getKanjiWord().equals(kanji)) {
				kanjis.remove(i);
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
	
	public boolean containsKanji(String word) {
		for (int i = 0; i < kanjis.size(); i++) {
			if (kanjis.get(i).getFrenchWord().equals(word) || kanjis.get(i).getHiraganaWord().equals(word) || kanjis.get(i).getKanjiWord().equals(word)) {
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

	public ArrayList<Kanji> getKanjis() {
		return kanjis;
	}

	public void setKanjis(ArrayList<Kanji> kanjis) {
		this.kanjis = kanjis;
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
			Writer write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			for (Word word : this.words) {
				write.write(word.getFrenchWord() + ":" + word.getJapaneseWord() + "\n");
				write.flush();
			}
			write.write("=\n");
			write.flush();
			for(Kanji kanji : this.kanjis) {
				write.write(kanji.getFrenchWord() + ":" + kanji.getHiraganaWord() + ":" + kanji.getKanjiWord() + "\n");
				write.flush();
			}
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
				BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				String line = read.readLine();
				Word word = null;
				Kanji kanji = null;
				
				while (line != null && !line.contains("=")) {
					String[] t = line.split(":");
					word = new Word(t[0], t[1]);
					this.words.add(word);
					line = read.readLine();
				}
				
				line = read.readLine();
				while(line != null) {
					String[] t = line.split(":");
					kanji = new Kanji(t[0], t[1], t[2]);
					this.kanjis.add(kanji);
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
