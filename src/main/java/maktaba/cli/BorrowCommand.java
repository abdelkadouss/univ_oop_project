package cli;

import cli.Cli.Command;
import core.LibraryService;

/**
 * BorrowCommand
 */
public class BorrowCommand extends Cli implements Command {
  public void run(String options) {
    String[] args = options.split(" ");
    if (args.length != 2) {
      return;
    }
    int bookId = Integer.parseInt(args[0]);
    int borrowerId = Integer.parseInt(args[1]);
    LibraryService service = new LibraryService();
    service.borrow(bookId, borrowerId);
  }
}
