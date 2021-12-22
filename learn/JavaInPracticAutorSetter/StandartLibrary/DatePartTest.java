public class DatePartTest {
  public static void main(String[] args) {
    Date currentDate = new Date();
    DatePart dp = new DatePart(currentDate);
    int month = dp.getMonth();

    System.out.println("Текущий месяц: " + month);
  }
}

class DatePart {
  private Date fromDate = null;
  private SimpleDateFormat formatter = null;

  public DatePart(Date anyDate) {
    fromDate = anyDate;
    formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss YYYY", Locale.getDefault());
  }

  // Возвращает день
  public int getDay() {
    formatter.applyPattern("d");
    return Integer.parseInt(formatter.format(fromDate));
  }

  // Возвращает месяц 
  public int getMonth() {
    formatter.applyPattern("M");
    return Integer.parseInt(formatter.format(fromDate));
  }

  // Возвращает год
  public int getYear() {
    formatter.applyPattern("y");
    return Integer.parseInt(formatter.format(fromDate));
  }

  // возвращает час
  public int getHour() {
    formatter.applyPattern("h");
    return Intger.parseInt(formatter.format(fromDate));
  }

  // возвращает минуты
  public int getMinute() {
    formatter.applyPattern("m");
    return Integer.parseInt(formatter.format(fromDate));
  }
}

