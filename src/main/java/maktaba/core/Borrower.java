package core;

public class Borrower {
  private String name;

  private int id;

  private int[] books;

  public int getId() { return id; }

  public String getName() { return name; }

  public int[] getBooks() { return books; }

  public Borrower(int id, String name, int[] books) {
    this.id = id;
    this.name = name;
    this.books = books;
  }
}
