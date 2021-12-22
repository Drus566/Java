import java.io.*;
import sun.misc.*;

public class Base64Demo {
  public static void main(String[] args) {
    /* Программа должна быть запущена 
     ** по крайней мере с одним параметром -
     ** строкой, подлежащей шифрованию */
    if (args.length == 0) {
      System.out.println("usage: Base64Demo text");
      System.exit(1);
    }
    String text = args[0];
    BASE64Encoder enc = new BASE64Encoder();
    String encoded = enc.encode(text.getBytes());
    enc = null;

    String decoded = null;
    try {
      BASE64Encoder dec = new BASE64Encoder();
      decoded = new String(dec.decodeBuffer(encoded));
      dec = null;
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    
    System.out.println("Закодировано: " + encoded);
    System.out.println("Декодировано: " + decoded);

    encoded = null;
    decoded = null;
  }
}
