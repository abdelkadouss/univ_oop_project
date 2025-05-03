package cli;

import cli.Cli.Command;
import core.Book;
import core.Borrower;
import storege.BooksRepository;
import storege.BorrowerRepository;

/**
 * ListCommand
 */
public class ListCommand extends Cli implements Command {

  public void run(String options) {
    if (options.equals("-b")) {
      System.out.println("list of books:");
      System.out.println("id | title | author | state");
      BooksRepository repo = new BooksRepository();
      Book[] books = repo.getAll();
      for (Book book : books) {
        System.out.println(book.getId() + " " + book.getTitle() + " " +
                           book.getAuthor() + " " + book.isState());
      }
    } else {
      System.out.println("list of borrowers:");
      System.out.println("id | name | books");
      BorrowerRepository repo = new BorrowerRepository();
      Borrower[] borrowers = repo.getAll();
      for (Borrower borrower : borrowers) {
        String books = "";
        for (int bookId : borrower.getBooks()) {
          books += bookId + " ";
        }
        System.out.println(borrower.getId() + " " + borrower.getName() + " " +
                           books);
      }
    }
  }
}
