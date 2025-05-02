package storege;

import core.Book;
import core.Borrower;

/**
 * storege the module that manages the json storage of the books and borrowers
 */
public class Storege {

  // the books json storage manager
  public interface BooksRepository {
    Book get(int bookId);

    Book[] getAll();

    void put(Book book);

    void updateStatus(int bookId, boolean isAvailable);

    boolean isAvailable(int bookId);
  }

  // the borrowers json storage manager
  public interface BorrowersRepository {
    Borrower get(int borrowerId);

    Borrower[] getAll();

    void put(Borrower borrower);

    void borrow(int bookId, int borrowerId);

    void returnBook(int bookId, int borrowerId);
  }
}
