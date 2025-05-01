package storege;

import core.Book;

/**
 * storege the module that manages the json storage of the books and borrowers
 */
public class Storege {

  // the books json storage manager
  public interface BooksRepository {
    Book get(int bookId);

    Book[] getAll();

    void put(int bookId);

    void updateStatus(int bookId, boolean isAvailable);

    boolean isAvailable(int bookId);
  }

  // the borrowers json storage manager
  public interface BorrowersRepository {
    Book get(int borrowerId);

    Book[] getAll();

    void put(int borrowerId);

    void borrow(int bookId, int borrowerId);

    void returnBook(int bookId, int borrowerId);
  }
}
