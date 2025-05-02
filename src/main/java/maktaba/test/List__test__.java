package test;

import cli.ListCommand;

/**
 * List__test__
 */
public class List__test__ {

  public static void main() {
    System.out.println("--- test list ---");
    ListCommand list = new ListCommand();
    list.run("-b");
    list.run("-r");
  }
}
