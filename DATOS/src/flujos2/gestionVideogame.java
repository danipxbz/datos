package flujos2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class gestionVideogame {

	public static void main(String[] args) throws IOException {
		File file=new File("F:\\CESUR\\2º\\eclipse\\DATOS\\Videojuegos.txt");
		if (file.exists()==false) new File("F:\\CESUR\\2º\\eclipse\\DATOS", "Videojuegos.txt").createNewFile();
		BufferedReader read=new BufferedReader(new FileReader("F:\\CESUR\\2º\\eclipse\\DATOS\\Videojuegos.txt"));
		BufferedWriter write=new BufferedWriter(new FileWriter(file, true));
		
		
		int opcion;
		
		do {
			System.out.println("Bienvenido. ¿Que desea hacer?"
															+ "\n1. Anadir nuevo videojuego."
															+ "\n2. Buscar un videojuego."
															+ "\n3. Borrar un videojuego."
															+ "\n4. Salir del programa.");
			opcion=getNumber();
			
			switch (opcion) {
			case 1:
				addVideogame(write);
				break;
			
			case 2:
				searchVideogame(read);
				break;
				
			case 3:
				deleteVideogame();
				break;
				
			case 4:
				System.out.println("Hasta pronto.");
				break;

			default:
				System.out.println("Opción incorrecta");
			}
			
		} while (opcion!=4);
		

	}
	
	private static void deleteVideogame() {
		
		
	}

	private static void searchVideogame(BufferedReader read) {
		System.out.print("Introduce el videojuego a mostrar: ");
		String name=getName();
		videojuego videogame=new videojuego();
		videogame.setTittle(name);
		
		System.out.println("Este es el videojuego que buscabas:\n");
		
	}

	private static void addVideogame(BufferedWriter write) throws IOException {
		String name, gen, plataform, resume;
		int year;
		System.out.print("Vamos a anadir un videojuego:\nNombre: ");
		name=getName();
		System.out.print("Genero: ");
		gen=getName();
		System.out.print("Ano: ");
		year=getNumber();
		System.out.print("Plataforma: ");
		plataform=getName();
		System.out.print("Resumen: ");
		resume=getName();
		
		videojuego videogame=new videojuego(name, gen, year, plataform, resume);
		
		write.write(videogame.toString());
		
		write.close();
		
		
	}

	public static int getNumber() {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		return num;
	}
	
	public static String getName() {
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		return name;
	}

}
