package core;

public class Book {

  public enum BookType { PAPER, ELECTRONIC }

  private String title;
  private BookType type;
  // true if available
  private boolean state;
  private String author;
}
