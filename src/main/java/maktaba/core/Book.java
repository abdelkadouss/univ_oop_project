package core;

public class Book {

  public enum BookType { PAPER, ELECTRONIC }

  private int id;
  private String title;
  private BookType type;
  // true if available
  private boolean state;

  private String author;

  public int getId() { return id; }

  public String getTitle() { return title; }

  public BookType getType() { return type; }

  public boolean isState() { return state; }

  public void setState(boolean state) { this.state = state; }

  public String getAuthor() { return author; }

  public Book(int id, String title, BookType type, String author,
              boolean state) {
    this.id = id;
    this.title = title;
    this.type = type;
    this.author = author;
    this.state = state;
  }
}
