package test;

import java.util.List;
import storege.Repository;

/**
 * Test
 */
public class Test {

  public static void main() {
    Repository repo = new Repository("books.txt");
    repo.push(List.of("1", "22", "3"));
    List<String> books = repo.pull();
    System.out.println(books.get(0));
    System.out.println(repo.pull());
    List<Integer> ids = repo.getIds();
    System.out.println(ids);
  }
}
