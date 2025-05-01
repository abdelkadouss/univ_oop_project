package core;

/**
 * core the module that interacts with storage modules and manage the services
 * process
 */
public class core {

  public interface LibraryService {
    void borrow(int bookId, int borrowerId);

    void returnBook(int bookId, int borrowerId);
  }
}
