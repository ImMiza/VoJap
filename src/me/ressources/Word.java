package me.ressources;

public class Word {

	private String frenchWord, japaneseWord;
	
	public Word(String french, String japanese) {
		this.frenchWord = french;
		this.japaneseWord = japanese;
	}

	public String getFrenchWord() {
		return frenchWord;
	}

	public void setFrenchWord(String frenchWord) {
		this.frenchWord = frenchWord;
	}

	public String getJapaneseWord() {
		return japaneseWord;
	}
	
	public String getRandomWord() {
		double r = Math.random();
		if(r < 0.5)
			return this.frenchWord;
		else
			return this.japaneseWord;
	}

	public void setJapaneseWord(String japaneseWord) {
		this.japaneseWord = japaneseWord;
	}
	
	@Override
	public String toString() {
		return "Francais: " + getFrenchWord() + ", Japonais: " + getJapaneseWord();
	}
}
