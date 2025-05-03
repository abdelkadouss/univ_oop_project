package test;

import java.util.List;
import storege.Repository;

/**
 * Repo__test__
 */
public class Repo__test__ {

  public static void main() {
    System.out.println("-- repo test --");
    Repository repo = new Repository("repo.txt");
    repo.push(List.of("1", "22", "3"));
    List<String> books = repo.pull();
    System.out.println(books.get(0));
    System.out.println(repo.pull());
    List<Integer> ids = repo.getIds();
    System.out.println(ids);
  }
}
