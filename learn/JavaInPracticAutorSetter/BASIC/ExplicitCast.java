public class ExplicitClass {
  public static void main(String[] args) {
    long l = 10; 
    double d = l; // неявное приведение типов (long в double)
    l = (long) d; // явное приведение (double в long)
  }
}
