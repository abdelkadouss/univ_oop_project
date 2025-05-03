package cli;

import cli.Cli.Command;
import core.Book;
import core.Borrower;
import storege.BooksRepository;
import storege.BorrowerRepository;

/**
 * GetCommand
 */
public class GetCommand extends Cli implements Command {
  public void run(String options) {
    String[] args = options.split(" ");
    if (args.length != 2) {
      return;
    }
    String action = args[0];
    int Id = Integer.parseInt(args[1]);
    switch (action) {
    case "-b":
      BooksRepository bRepo = new BooksRepository();
      Book book = bRepo.get(Id);
      if (book != null) {
        System.out.println("the book " + Id);
        System.out.println("id: " + book.getId());
        System.out.println("title: " + book.getTitle());
        System.out.println("type: " + book.getType());
        System.out.println("author: " + book.getAuthor());
        System.out.println("state: " +
                           (book.isState() ? "available" : "not available"));
      }
      break;
    case "-r":
      BorrowerRepository rRepo = new BorrowerRepository();
      Borrower borrower = rRepo.get(Id);
      if (borrower != null) {
        System.out.println("the borrower " + Id);
        System.out.println("id: " + borrower.getId());
        System.out.println("name: " + borrower.getName());
        String books = "";
        for (int bookId : borrower.getBooks()) {
          books += bookId + " ";
        }
        System.out.println("books: " + books);
      }
      break;
    default:
      System.out.println("Error in get command (bad use, unknown action:')" +
                         action + "'");
      break;
    }
  }
}
