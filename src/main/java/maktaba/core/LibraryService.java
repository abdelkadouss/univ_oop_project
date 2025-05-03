package core;

import storege.BooksRepository;
import storege.BorrowerRepository;

/**
 * LibraryService
 */
public class LibraryService implements core.LibraryService {

  public void borrow(int bookId, int borrowerId) {
    BooksRepository booksRepo = new BooksRepository();
    BorrowerRepository borrowersRepo = new BorrowerRepository();
    if (booksRepo.isAvailable(bookId) &&
        borrowersRepo.getIds().contains(borrowerId)) {
      booksRepo.updateStatus(bookId, false);
      borrowersRepo.borrow(bookId, borrowerId);
    } else {
      System.out.println("Book not available or borrower not found");
    }
  }

  public void returnBook(int bookId, int borrowerId) {
    BooksRepository booksRepo = new BooksRepository();
    BorrowerRepository borrowersRepo = new BorrowerRepository();
    if (booksRepo.isAvailable(bookId) &&
        borrowersRepo.getIds().contains(borrowerId)) {
      booksRepo.updateStatus(bookId, true);
      borrowersRepo.returnBook(bookId, borrowerId);
    } else {
      System.out.println("Book not available or borrower not found");
    }
  }
}
