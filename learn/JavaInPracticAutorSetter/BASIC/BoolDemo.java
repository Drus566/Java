public class BoolDemo {
  public static void main(String[] args) {
    boolean b;

    b = false;
    System.out.println("b равно " + b);
    b = true;
    System.out.println("b равно " + b);

    if (b) System.out.println("Как вы думаеет, увидите эту строку?");

    System.out.println("Выражение 10 > 9 имеет значение  " + (10 > 9));
  }
}
