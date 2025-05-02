package cli;

import cli.Cli.Command;
;

/**
 * HelpCommand
 */
public class HelpCommand extends Cli implements Command {
  public void run() {
    System.out.println("maktaba is a library management tool");
    System.out.println("Usage: maktaba [options] <command>");
    System.out.println("Commands:");
    System.out.println("  help");
    System.out.println("  list");
    System.out.println("  add #if book [name] [type] [author] [state], if " +
                       "borrower [name] [books]");
    System.out.println("  get [id]");
    System.out.println("  borrow [borrower id] [book id]");
    System.out.println("  return [borrower id] [book id]");
    System.out.println("options:");
    System.out.println("-b # for a book");
    System.out.println("-r # for a borrower");
  }
}
