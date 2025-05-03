package test;

import cli.*;

/**
 * cmds__test__
 */
public class cmds__test__ {

  public static void main() {
    System.out.println("---- test cmds ----");
    AddCommand add = new AddCommand();
    add.run("-b name PAPER author true");
    // add.run("-t name PAPER author true");// error
    add.run("-r name 1,3,5");
    add.run("-r name 1,3,5,6 ignoreOverflow");
    BorrowCommand borrow = new BorrowCommand();
    // borrow.run("5 14");
    ReturnCommand returnCommand = new ReturnCommand();
    returnCommand.run("5 14");
    GetCommand get = new GetCommand();
    get.run("-r 14");
    HelpCommand help = new HelpCommand();
    System.out.println("===== help =====");
    System.out.println();
    help.run("");
  }
}
