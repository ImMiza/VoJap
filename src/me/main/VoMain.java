package me.main;


import java.io.File;
import java.io.IOException;

import me.ressources.Dictionnary;
import me.ressources.mode.Index;

public class VoMain {
	
	public static Dictionnary dictionnary;
	
	public static int defaultWidth;
	public static int defaultHeight;
	private static String defaultTitle;
	private static File file;
	
	public static void main(String[] args) {
		defaultWidth = 800;
		defaultHeight = 400;
		defaultTitle = "VoJap (Beta)";
		
		file = new File("dictionnaire.vo");
		dictionnary = new Dictionnary();
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			dictionnary.load(file);
		}
		
		new Index(defaultTitle, defaultWidth, defaultHeight);
	}

	public static Dictionnary getDictionnary()
	{
		return dictionnary;
	}

	public static void setDictionnary(Dictionnary dictionnary)
	{
		VoMain.dictionnary = dictionnary;
	}

	public static int getDefaultWidth() {
		return defaultWidth;
	}

	public static void setDefaultWidth(int defaultWidth) {
		VoMain.defaultWidth = defaultWidth;
	}

	public static int getDefaultHeight() {
		return defaultHeight;
	}

	public static void setDefaultHeight(int defaultHeight) {
		VoMain.defaultHeight = defaultHeight;
	}

	public static String getDefaultTitle() {
		return defaultTitle;
	}

	public static void setDefaultTitle(String defaultTitle) {
		VoMain.defaultTitle = defaultTitle;
	}

	public static File getFile() {
		return file;
	}

	public static void setFile(File file) {
		VoMain.file = file;
	}

}
