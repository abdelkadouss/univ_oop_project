package storege;

import core.Borrower;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BorrowerRepository
 */
public class BorrowerRepository
    extends Repository implements Storege.BorrowersRepository {

  public BorrowerRepository() { super("borrowers.txt"); }

  public Borrower get(int borrowerId) {
    List<String> lines = this.pull();
    for (String line : lines) {
      if (line == null || line.trim().isEmpty()) {
        continue; // Skip empty lines
      }

      try {
        String[] parts = line.split(" ");
        int id = Integer.parseInt(parts[0]);
        if (id == borrowerId) {
          // Parse books (assuming they're comma-separated after name)
          String[] bookIds = parts[2].split(",");
          int[] books = new int[bookIds.length];
          for (int i = 0; i < bookIds.length; i++) {
            books[i] = Integer.parseInt(bookIds[i]);
          }

          return new Borrower(id,       // borrower ID
                              parts[1], // name
                              books     // array of book IDs
          );
        }
      } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        System.err.println("Skipping invalid line: " + line);
      }
    }
    return null;
  }

  public Borrower[] getAll() {
    Borrower[] borrowers = new Borrower[this.getIds().size()];
    List<String> lines = this.pull();
    for (String line : lines) {
      if (line == null || line.trim().isEmpty()) {
        continue; // Skip empty lines
      }

      try {
        String[] parts = line.split(" ");
        int id = Integer.parseInt(parts[0]);
        // Parse books (assuming they're comma-separated after name)
        String[] bookIds = parts[2].split(",");
        int[] books = new int[bookIds.length];
        for (int i = 0; i < bookIds.length; i++) {
          books[i] = Integer.parseInt(bookIds[i]);

          Borrower newBorrower = new Borrower(id,       // borrower ID
                                              parts[1], // name
                                              books     // array of book IDs
          );
          borrowers[i] = newBorrower;
        }
      } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        System.err.println("Skipping invalid line: " + line);
      }
    }
    return borrowers;
  }

  public void put(Borrower Borrower) {
    int[] books = Borrower.getBooks();
    String booksStr = Arrays.stream(books)
                          .mapToObj(String::valueOf)
                          .collect(Collectors.joining(","));
    this.push(List.of(String.format("%d %s %s", Borrower.getId(),
                                    Borrower.getName(), booksStr)));
  }

  public void borrow(int bookId, int borrowerId) {
    List<String> lines = this.pull();
    for (String line : lines) {
      if (line == null || line.trim().isEmpty()) {
        continue; // Skip empty lines
      }

      try {
        String[] parts = line.split(" ");
        String idAsString = parts[0];
        int id = Integer.parseInt(idAsString);
        if (id == borrowerId) {
          // make the new line to push
          String newLine = String.format("%d %s %s", borrowerId, parts[1],
                                         parts[2] + "," + bookId);
          this.delete(borrowerId);
          this.push(List.of(newLine));
          // i let it keep going to clean up the repated ids
        }
      } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Handle lines that don't contain valid IDs
        System.err.println("Skipping invalid line: " + line);
      }
    }
  }

  public void returnBook(int bookId, int borrowerId) {
    List<String> lines = this.pull();
    for (String line : lines) {
      if (line == null || line.trim().isEmpty()) {
        continue; // Skip empty lines
      }

      try {
        String[] parts = line.split(" ");
        String idAsString = parts[0];
        int id = Integer.parseInt(idAsString);
        if (id == borrowerId) {
          String bookIdAsString = String.valueOf(bookId);
          // make the new line to push
          String[] newBooksArr = parts[2].split(",");
          String newBooks = Arrays.stream(newBooksArr)
                                .filter(book -> !book.equals(bookIdAsString))
                                .collect(Collectors.joining(","));
          String newLine =
              String.format("%d %s %s", borrowerId, parts[1], newBooks);
          this.delete(borrowerId);
          this.push(List.of(newLine));
          break;
          // i let it keep going to clean up the repated ids
        }
      } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Handle lines that don't contain valid IDs
        System.err.println("Skipping invalid line: " + line);
      }
    }
  }
}
