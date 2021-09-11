package scr.builtinfunction;

import java.util.function.*;
import java.util.Scanner;

public class BankSystem {
  public static Scanner SC = new Scanner(System.in);

  public static void main(String[] args) {
    Integer account = 10000;

    BiFunction<Integer, Integer, Integer> withdraw = (inputAcount, amount) -> inputAcount - amount; //return account after withdraw
    Consumer<Integer> showAccount = (inputAcount) -> System.out.println("Your money: " + inputAcount); //print money in the account
    Predicate<String> checkPassword = (inputPassword) -> inputPassword.equals("12345"); //check password

    System.out.print("Password: ");
    String password = SC.nextLine();
    
    if (checkPassword.test(password)) {
      
      showAccount.accept(account);

      System.out.print("Withdraw amount: ");
      Integer amount = Integer.parseInt(SC.nextLine());
      account = withdraw.apply(account, amount);
      System.out.println("Withdraw successfully!");

      showAccount.accept(account);
    }

  }
}
