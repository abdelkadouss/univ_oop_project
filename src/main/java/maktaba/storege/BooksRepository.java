package storege;

import core.Book;
import java.util.List;

/**
 * BooksRepository, will it's a clear name no description needed right?
 */
public class BooksRepository
    extends Repository implements Storege.BooksRepository {
  private static final Repository repo = new Repository("books.txt");

  public BooksRepository(String filename) { super(filename); }

  public Book get(int bookId) {
    List<String> lines = pull();
    for (String line : lines) {
      if (line == null || line.trim().isEmpty()) {
        continue; // Skip empty lines
      }

      try {
        String[] parts = line.split(" ");
        String idAsString = parts[0];
        int id = Integer.parseInt(idAsString);
        if (id == bookId) {
          // int id, String title, BookType type, String author, boolean state
          return new Book(id, parts[1], Book.BookType.valueOf(parts[2]),
                          parts[3], Boolean.parseBoolean(parts[4]));
        }
      } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Handle lines that don't contain valid IDs
        System.err.println("Skipping invalid line: " + line);
      }
    }
    return null;
  }

  public Book[] getAll() {
    List<Integer> ids = getIds();
    Book[] books = new Book[ids.size()];
    for (int i = 0; i < ids.size(); i++) {
      books[i] = get(ids.get(i));
    }
    return books;
  }

  public void put(Book book) {
    String line = String.format("%d %s %s %s %s", book.getId(), book.getTitle(),
                                book.getType().toString(), book.getAuthor(),
                                book.isState());
    List<String> lines = List.of(line);
    repo.push(lines);
  }

  public void updateStatus(int bookId, boolean isAvailable) {
    Book book = this.get(bookId);
    book.setState(isAvailable);
    repo.delete(bookId);
    put(book);
  }

  public boolean isAvailable(int bookId) {
    List<Integer> id = this.getIds();
    return id.contains(bookId);
  }
}
