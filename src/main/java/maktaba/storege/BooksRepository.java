package storege;

import core.Book;

/**
 * BooksRepository, will it's a clear name no description needed right?
 */
public class BooksRepository
    extends Repository implements Storege.BooksRepository {

  public BooksRepository(String filename) {
    super(filename);
  }

  public Book get(int bookId) {
    /* TODO: */
    return null;
  }

  public Book[] getAll() {
    /* TODO: */
    return null;
  }

  public void put(int bookId) {
    /* TODO: */}

  public void updateStatus(int bookId, boolean isAvailable) {
    /* TODO: */ }

  public boolean isAvailable(int bookId) {
    /* TODO: */
    return false;
  }
}
