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
   }
}
