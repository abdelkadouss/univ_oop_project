import java.util.List;
import storege.Repository;

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

    Repository repo = new Repository("books.txt");
    // repo.push(List.of("1", "2", "3"));
    List<String> books = repo.pull();
    System.out.println(books.get(0));
    repo.push(List.of("this", "is", "a", "test"));
    System.out.println(repo.pull());
  }
}
