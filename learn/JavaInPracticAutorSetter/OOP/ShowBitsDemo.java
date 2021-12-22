import java.io.PrintStream;

public class ShowBitsDemo {
  private static PrintStream out = System.out;

  public static void main(String[] args) {
    ShowBits b = new ShowBits(8);
    ShowBits i = new ShowBits(32);
    ShowBits li = new ShowBits(64);

    out.print("128 в двоичном виде ");
    b.show(128, out);

    out.print("87987 в двоичном виде ");
    i.show(87987, out);

    out.print("237658768 в двоичном виде ");
    li.show(237658768, out);

    out.print("Младшие 8 бит числа 87987 в двоичном виде ");
    b.show(87987, out);
  }
}

public class ShowBits {
  private int numbits;

  public ShowBits(int numbits) {
    this.numbits = numbits;
  }

  public String getBinaryForm(long val) {
    long mask = 1;
    String form = "";
    mask <<= numbits - 1;

    int spacer = 0;
    for(; mask != 0; mask >>>= 1) {
      if ((val & mask) != 0) {
        form += "1";
      } else {
        form += "0";
      }

      spacer++;
      if ((spacer % 8) == 0) {
        form += " ";
        spacer = 0;
      }
    }

    return form;
  }

  public void show(long val, PrintStream out) {
    String binaryForm = getBinaryForm(val);
    out.println(binaryForm);
  }
}
