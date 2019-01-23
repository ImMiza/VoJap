package me.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import me.ressources.Dictionnary;
import me.ressources.graphics.Button;
import me.ressources.graphics.Text;
import me.ressources.graphics.Window;

public class VoMain {
	
	public static void main(String[] args) {
		Dictionnary dictionnary = new Dictionnary();
		File file = new File("/home/miza/Bureau/dictionnaire.vo");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		createWelcomeMenu();
	}
	
	public static void createWelcomeMenu() {
		Window window = new Window("VoJap (Beta)", 1000, 600);
		
		Text name = new Text("VoJap", (int) (window.getX() / 1.5), (window.getY() / 10),(int) ((window.getX() / 2) - ((window.getX() / 1.5) / 2)), (window.getY() / 10));
		Button button = new Button("test", 50, 50, window.getX() / 2, window.getY(), new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent key) {
				System.out.println("ZBEUB");
			}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		window.addButton(button);
		window.addText(name);
	}
}
