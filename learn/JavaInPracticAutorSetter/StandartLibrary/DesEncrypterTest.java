import javax.crypto.*;
import java.io.*;
import sun.misc.*;
import java.security.*;
import java.util.Base64;

// пример шифровки произвольного текста
public class DesEncrypterTest {
  public static void main(String[] args) {
    try {
      SecretKey key = KeyGenerator.getInstance("DES").generateKey();

      DesEncrypter encrypter = new DesEncrypter(key);
      String encrypted = encrypter.encrypt("Проверка");
      String decrypted = encrypter.decrypt(encrypted);
      
      System.out.println("Расшифровано: " + decrypted);
    } catch (NoSuchAlgorithmException nsae) {
      // игнор
    }
  }
}
  
class DesEncrypter {
  Cipher ecipher = null;
  Cipher dcipher = null;

  public DesEncrypter(SecretKey key) {
    try {
      ecipher = Cipher.getInstance("DES");
      dcipher = Cipher.getInstance("DES");

      ecipher.init(Cipher.ENCRYPT_MODE, key);
      dcipher.init(Cipher.DECRYPT_MODE, key);
    } catch (NoSuchPaddingException nspe) {
      // игнор
    } catch (NoSuchAlgorithmException nsae) {
      // игнор
    } catch (InvalidKeyException ike) {
      // игнор
    }
  }

  public String encrypt(String str) {
    try {
      byte[] utf8 = str.getBytes("utf8");
      byte[] enc = ecipher.doFinal(utf8);
      return Base64.getEncoder().encodeToString(enc);
    } catch (UnsupportedEncodingException uee) {
      // игнор 
    } catch (BadPaddingException bpe) {
      // игнор
    } catch (IllegalBlockSizeException ibse) {
      // игнор
    }

    return null;
  }

  public String decrypt(String str) {
    try {
      byte[] dec = Base64.getDecoder().decode(str);
      byte[] utf8 = dcipher.doFinal(dec);
      return new String(utf8, "utf8");
    } catch (IOException ioe) {
      // игнор
    } catch (BadPaddingException bpe) {
      // игнор
    } catch (IllegalBlockSizeException ibse) {
      // игнор
    }
    return null;
  }
}

