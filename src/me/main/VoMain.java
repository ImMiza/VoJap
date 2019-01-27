package me.main;

import java.io.File;
import java.io.IOException;

import me.ressources.Dictionnary;
import me.ressources.mode.Index;

public class VoMain {
	
	public static Dictionnary dictionnary;
	public static File file;
	
	public static int defaultWidth;
	public static int defaultHeight;
	private static String defaultTitle;
	
	public static void main(String[] args) {
		defaultWidth = 800;
		defaultHeight = 400;
		defaultTitle = "VoJap (Beta)";
		
		dictionnary = new Dictionnary();
		file = new File("dictionnaire.vo");
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

	public static File getFile()
	{
		return file;
	}

	public static void setFile(File file)
	{
		VoMain.file = file;
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
}
