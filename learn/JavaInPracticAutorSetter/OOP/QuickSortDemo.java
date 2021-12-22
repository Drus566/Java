class QuickSort {
  static void sort(char items[]) {
    quicksort(items, 0, items.length - 1);
  }

  private static void quicksort(char items[], int left, int right) {
    int top, bottom;
    char comparand, value;

    top = left; // первая позиция 
    bottom = right; // последняя позиция
    // выбор компаранда - символ из середины массива
    comparand = items[((left + right) / 2)];

    // разделение последовательности на две части
    do {
      while ((items[top] < comparand) && (top < right)) top++;
      while ((comparand < items[bottom]) && (bottom > left)) bottom--; 

      if (top <= bottom) {
        value = items[top];
        items[top] = items[bottom];
        items[bottom] = value;
        top++;
        bottom--;
      }
    } while (top <= bottom);
    /* Если закомментированный код включить в программу, будет виден промежуточный
     ** этап сортировки
    if (((right + 1) - left) == items.length) {
      for (int i = 0; i < items.length; i++)
      System.out.print(items[i]);
      System.out.println();
    }
    */
    // рекурсивная сортировка первой части
    if (left < bottom) quicksort(items, left, bottom);
    // рекурсивная сортировка второй части
    if (top < right) quicksort(items, top, right);
  }
}

class QuickSortDemo {
  public static void main(String[] args) {
    char seq[] = {'h', 'e', 'd', 'a', 'c', 'i'};

    System.out.println("Исходный порядок символов:");
    for (int i = 0; i < seq.length; i++) {
      System.out.print(seq[i]);
    }

    System.out.println();
    QuickSort.sort(seq);

    System.out.println("Сортированный порядок:");
    for (int i = 0; i < seq.length; i++)
      System.out.print(seq[i]);

    System.out.println("");
  }
}
