import java.io.*;
public class LogReader {
  public static void main(String[] args) {
    /* первый параметр должен содержать имя файла протокола */
    if (args.length == 0) {
      System.out.println("Вызов: java LogReader <файл_протокола>");
      System.exit(0);
    }

    /* последовательное чтение файла */
    String logFile = null;
    BufferedReader br = null;
    try {
      logFile = args[0];
      br = new BufferedReader(new InputStreamReader(new FileInputStream(logFile)));
      while (true) {
        String line = br.readLine();
        if (line != null) {
          // Отображение строки
          System.out.println(line);
        } else {
          try {
            // спящий режим программы
            Thread.sleep(500);
          } catch (InterruptedException ie) {
            ie.printStackTrace();
          }
        }
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
