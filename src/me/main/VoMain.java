package me.main;

import java.io.File;
import java.io.IOException;

import me.ressources.Dictionnary;
import me.ressources.graphics.WindowGestion;

public class VoMain {
	
	public static Dictionnary dictionnary;
	public static File file;
	
	public static void main(String[] args) {
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
		
		WindowGestion.openIndexWindow();
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
}
