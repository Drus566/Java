import java.io.*;

public class ReadInput {
  String cmd = null;
  Process proc = null;
  InputStream input = null;

  BufferedReader in = null;
  // Конструктор класса ReadInput
  // может вызвать исключение IOException
  public ReadInput(String cmd) throws IOException {
    this.cmd = cmd;

    try {
      // запуск процесса, созданного именем исполняемого файла
      proc = Runtime.getRuntime().exec(cmd);
      // перехват его потока вывода
      input = proc.getInputStream();
      in = new BufferedReader(new InputStreamReader(input));
    } catch (IOException ioe) {
      throw ioe;
    }
  }

  // метод, считывающий очередную строку
  public String readLine() throws IOException {
    String line = in.readLine(); 
    // Проверяется пустоты строки
    while ((line == "\r") | (line == "")) {
      line = in.readLine();  
    }
    return line;
  }
  
  // закрытие запущенной программы
  public void close() {
    try {
      in.close();
      input.close();
      proc.destroy();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } finally {
      in = null;
      input = null;
      proc = null;
    }
  }

  public static void main(String[] args) {
    String cmd = null;
    ReadInput ri = null;
    // Если исполняемый файл не указан, запускаем ping localhost
    if (args.length > 0) {
      cmd = args[0];
    } else {
      cmd = "ping localhost";
    }

    try {
      ri = new ReadInput(cmd);

      String line = null;
      // вывод каждой строки на экран
      while ((line = ri.readLine()) != null)
        if (line != "\r")
          { System.out.println("java:>" + line);}
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } finally {
      ri.close();
      ri = null;
    }
  }
}
