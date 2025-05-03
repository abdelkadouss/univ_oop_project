package test;

import core.Book;
import storege.BooksRepository;

/**
 * BookRepo__test__
 */
public class BookRepo__test__ {

  public static void main() {
    System.out.println("-- book repo test --");
    BooksRepository repo = new BooksRepository();
    int idsLength = repo.getIds().size();
    Book book =
        new Book(idsLength, "title", Book.BookType.PAPER, "author", true);
    repo.put(book);
    Book bookFromRepo = repo.get(1);
    System.out.println("title: " + bookFromRepo.getTitle() + " state: " +
                       (bookFromRepo.isState() ? "available" : "unavailable"));
  }
}
