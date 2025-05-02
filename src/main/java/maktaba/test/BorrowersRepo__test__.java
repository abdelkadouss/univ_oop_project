package test;

import core.Borrower;
import storege.BorrowerRepository;

/**
 * BorrowersRepo__test__
 */
public class BorrowersRepo__test__ {

  public static void main() {
    System.out.println("--- test borrower repo ---");
    BorrowerRepository repo = new BorrowerRepository();
    int[] ids = new int[] {1, 2, 3};

    repo.put(new Borrower(1, "Mohamed", ids));

    Borrower borrower = repo.get(1);
    System.out.println("id:"
                       + " " + borrower.getId() + " "
                       + "name:"
                       + " " + borrower.getName());

    repo.borrow(5, 1);
    repo.borrow(6, 1);
    borrower = repo.get(1);
    System.out.println(borrower.getBooks()[3]);
    System.out.println("the target: " + borrower.getBooks()[1]);
    repo.returnBook(2, 1);
    borrower = repo.get(1);
    System.out.println("after retrun: " + borrower.getBooks()[1]);
  }
}
