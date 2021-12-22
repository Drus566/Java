import java.io.*;
public class HelloWorld {
	public static void main(String[] args) {
		try {
			System.setOut(new RusPrintStream());
      System.setErr(new RusPrintStream());
		} catch (UnsupportedEncodingException uee) {
			System.out.println("Environment doesn't support encoding.");	
		} finally {
			System.out.println("Вывод русских символов поддерживается!");	
		}
	}
}

// Класс, запускающий PrintStream с русскоязычной кодировкой
final class RusPrintWriter {
    private PrintWriter pw = null;
    private PrintStream ps = null;
    
    public RusPrintWriter(PrintStream ps) {
        Writer osw = null;
        BufferedWriter bw = null;
        
        this.ps = ps;
        
        try {
            osw = new OutputStreamWriter(ps, "Cp852");
            bw = new BufferedWriter(osw);
            pw = new PrintWriter(bw, true);
        } catch (UnsupportedEncodingException uee) {
            /* Вы можете игнорировать исключение,
            или обрабатывать его в других классах так,
            чтобы оно не влияло на остальной код
            смотрите реализацию метода println() */
        } finally {
            osw = null; 
            bw = null;
        }
    }
    public void println(String line) {
        if (pw != null) {
            pw.println(line);   
        } else {
            ps.println(line);   
        }
    }   
}
