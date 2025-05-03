package cli;

import core.Book;
import core.Book.BookType;
import core.Borrower;
import storege.BooksRepository;
import storege.BorrowerRepository;

/**
 * AddCommand
 */
public class AddCommand {

  public void run(String options) {
    String[] args = options.split(" ");
    if (args.length < 3) {
      return;
    }
    if (args[0].equals("-b")) {
      String name = args[1];
      BookType type = core.Book.BookType.valueOf(args[2]);
      String author = args[3];
      boolean state = Boolean.parseBoolean(args[4]);

      BooksRepository repo = new BooksRepository();
      int idLen = repo.getIds().size();
      Book book = new Book(idLen, name, type, author, state);
      repo.put(book);
    } else {
      String name = args[1];
      String books = args[2];
      String[] booksArr = books.split(",");
      int[] bookIds = new int[booksArr.length];
      for (int i = 0; i < booksArr.length; i++) {
        bookIds[i] = Integer.parseInt(booksArr[i]);
      }
      BorrowerRepository repo = new BorrowerRepository();
      int repoLen = repo.getIds().size();
      Borrower borrower = new Borrower(repoLen, name, bookIds);
      repo.put(borrower);
    }
  }
}
