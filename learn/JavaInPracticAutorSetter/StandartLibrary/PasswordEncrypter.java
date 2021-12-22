public class PasswordEncrypter {
  // зашифрованный пароль
  public static byte[] encrypt(String password) {
    try {
      MessageDigest d = MessageDigest.getInstance("sha-1");
      d.update(password.getBytes());
      return d.digest();
    } catch (NoSuchAlgorithmException nsae) {
      // игнорируем
    }

    return null;
  }
}
