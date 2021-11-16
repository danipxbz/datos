package tema1;
import java.io.*;
public class escribir100 {
	public static void main(String[] args) throws IOException {
		BufferedWriter escritura = new BufferedWriter(new FileWriter("./num_naturales.txt"));
		String num;
		for (int i = 0; i < 100; i++) {
			num=""+i;
			escritura.write(num);
			escritura.flush();
			escritura.newLine();
		}
		escritura.close();
		
		FileInputStream archivo=new FileInputStream("./num_naturales.txt");
		int i;
		while ((i=archivo.read())!=-1) {
			System.out.print((char)i);
		}
	}
}