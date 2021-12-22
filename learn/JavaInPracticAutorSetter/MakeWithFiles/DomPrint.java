import java.io.*;
import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.*;

class DomPrint {
  // вывод отступа для разделения уровней
  private static void printIndentation(int level) {
    // отступ равен 3 пробелам * номер уровня
    for (int i = 0; i < level; i++) {
      System.out.print("    ");
    }
  }

  // печать содержимого узла
  private static void print(Node node, int level) {
    // для каждого последующего уровня выводится пустая строка и отступ
    if (level > 0) {
      System.out.println("");
      printIndentation(level);
    }
    // вывод имени узла
    System.out.println(node.getNodeName().toString() + ":");

    // вывод атрибутов узла, если они есть
    if (node.hasAttributes()) {
      NamedNodeMap attributes = node.getAttributes();
      if (attributes.getLength() > 0) {
        // атрибуты - это следующий уровень
        level++;
        for (int i = 0; i < attributes.getLength(); i++) {
          Node attribute = attributes.item(i);
          // вывод после отступа имени и значения атрибута
          printIndentation(level);
          String s = "." + attribute.getNodeName() + "=";
          System.out.println(s + attribute.getNodeValue());
        }
        level--;
      }
    }
    
    String value = node.getNodeValue();
    value = (value == null ? "" : value.trim());
    if (value.length() > 0) {
      printIndentation(level);
      System.out.println(value);
    }

    // печать дочерних узлов, если они есть
    if (node.hasChildNodes()) {
      // дочерние узлы - это следующий уровень
      level++;
      NodeList children = node.getChildNodes();

      for (int i = 0; i < children.getLength(); i++) {
        Node child = children.item(i);
        print(child, level);
      }
    }
  }

  public static void main(String[] args) {
     // утилита принимает один параметр: имя XML файла
     if (args.length < 1) {
      System.out.println("Usage java DomPrint имя файла xml");
      System.exit(0);
     }
     File docFile = new File(args[0]);
     try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setIgnoringComments(true);

      DocumentBuilderFactory builder = factory.newDocumentBuilder();

      // разборка входного файла
      Document doc = builder.parse(docFile);
      // печать разобранного документа
      print(doc.getDocumentElement(), 0);
     } catch (Exception ex) {
      System.out.println(ex);
     }
  }
}
