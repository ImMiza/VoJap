package me.ressources;

public class Kanji {

	private String frenchWord;
	private String hiraganaWord;
	private String kanjiWord;
	
	public Kanji(String frenchWord, String hiraganaWord, String kanjiWord) {
		this.frenchWord = frenchWord;
		this.hiraganaWord = hiraganaWord;
		this.kanjiWord = kanjiWord;
	}

	public String getFrenchWord() {
		return frenchWord;
	}

	public void setFrenchWord(String frenchWord) {
		this.frenchWord = frenchWord;
	}

	public String getHiraganaWord() {
		return hiraganaWord;
	}

	public void setHiraganaWord(String hiraganaWord) {
		this.hiraganaWord = hiraganaWord;
	}

	public String getKanjiWord() {
		return kanjiWord;
	}

	public void setKanjiWord(String kanjiWord) {
		this.kanjiWord = kanjiWord;
	}
}
