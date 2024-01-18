package be.tvde.lambdas._002;

import java.util.function.Predicate; //pre-defined in the API

//own custom Functional interface
interface Evaluate<T> {
   boolean isNegative(T t);
}

public class TestPredicate {

   public static void main(String[] args) {
      //Evaluate<T> is a functional interface -> 1 abstract method
      Evaluate<Integer> lambda = i -> i < 0;
      System.out.println("Evaluate: " + lambda.isNegative(-1)); //true
      System.out.println("Evaluate: " + lambda.isNegative(1)); //false

      Predicate<Integer> predicate = i -> i < 0;
      System.out.println("Predicate: " + predicate.test(-1)); //true
      System.out.println("Predicate: " + predicate.test(1)); //false

      int x = 4;
      System.out.println("Is " + x + " even? " + check(x, n -> n % 2 == 0)); //true
      x = 7;
      System.out.println("Is " + x + " even? " + check(x, n -> n % 2 == 0)); //false

      String name = "Mr. Joe Bloggs";
      System.out.println("Does " + name + " start with Mr. ? " +
                         check(name, s -> s.startsWith("Mr."))); //true
      name = "Ms. Ann Bloggs";
      System.out.println("Does " + name + " start with Mr. ? " +
                         check(name, s -> s.startsWith("Mr."))); //false
   }

   static <T> boolean check(T t, Predicate<T> lambda) {
      return lambda.test(t);
   }
}
