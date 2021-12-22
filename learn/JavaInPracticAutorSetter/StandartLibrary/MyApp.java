import java.io.*;
public class MyApp {
	public static void main(String[] args) {
		try {
			PrintStream errOut = new PrintStream(new FileOutputStream("Error.log"));
			System.setErr(errOut);
			
			PrintStream sysOut = new PrintStream(new FileOutputStream("Debug.log"));
			System.setOut(sysOut);
		} catch (Exception e) {}
		
		System.out.println("Сообщение о нормальной работе программы");
		System.err.println("Сообщение об ошибках");
	}
}
