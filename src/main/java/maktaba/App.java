import java.util.List;

/**
 * the main class that runs the application this one handles the command line
 * arguments then decides what to do
 *
 */
public class App {
  public static void main(String[] args) {
    System.out.println("Hello CLI!");

    if (args.length > 0) {
      if (args[0].equals("list")) {
        System.out.println("list");
      }
    }
  }
}
