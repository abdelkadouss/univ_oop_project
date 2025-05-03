
import cli.*;
import java.util.Arrays;
// import test.Test; // for testing

/**
 * the main class that runs the application this one handles the command line
 * arguments then decides what to do
 *
 */
public class App {
  public static void main(String[] args) {
    if (args[0].equals("-b") || args[0].equals("-r")) {
      String at = (args[0].equals("-b") ? "book" : "borrower");
      String cmd = args[1];
      String argsStr =
          String.join(" ", Arrays.copyOfRange(args, 2, args.length));
      hundleCmd(at, cmd, argsStr);
    } else if (args[0].equals("help")) {
      HelpCommand help = new HelpCommand();
      help.run("");
    } else {
      System.out.println("error");
    }

    // for testing
    // Test test = new Test();
    // test.main();
  }

  public static void hundleCmd(String at, String cmd, String args) {
    String to = (at.equals("book") ? "-b" : "-r");
    switch (cmd) {
    case "add":
      AddCommand add = new AddCommand();
      add.run(to + " " + args);
      break;
    case "borrow":
      BorrowCommand borrow = new BorrowCommand();
      borrow.run(args);
      break;
    case "return":
      ReturnCommand returnCommand = new ReturnCommand();
      returnCommand.run(args);
      break;
    case "get":
      GetCommand get = new GetCommand();
      get.run(to + " " + args);
      break;
    case "list":
      ListCommand list = new ListCommand();
      list.run(to);
      break;
    }
  }
}
