package tema1;

import java.io.*;

public class verTxt {
	public static void main(String[] args) {
		File dir=new File("F:\\CESUR\\1º\\Programacion\\Tema 4");
		String [] archivos=dir.list();
		System.out.println("Archivos .txt:");
		for (int i = 0; i < archivos.length; i++) {
			if (archivos[i].endsWith(".txt")) {
				System.out.println(archivos[i]);
			}
		}
	}
}