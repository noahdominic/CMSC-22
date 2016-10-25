import java.util.*;
import java.lang;

public class TestAccount {
  public static void main (String args[]){
	Account ac = new Account (701, 100.00);

	ac.credit(50.00);
	ac.debit(51.00);

	System.out.println("Current Account Status: ");
	System.out.print(ac);
  }
}
