package be.tvde.lambdas._003;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {

   public static void main(String[] args) {
      PredicateTest pt = new PredicateTest();
      pt.predicate();
      pt.biPredicate();
   }

   public void predicate() {
      //Predicate<T> is a functional interface with one abstract method:
      //    boolean test(T t);
      Predicate<String> stringPredicate = s -> s.contains("City");
      System.out.println(stringPredicate.test("New York City")); //true
   }

   public void biPredicate() {
      //BiPredicate<T, U> is a functional interface with one abstract method:
      //    boolean test(T t, U u);
      BiPredicate<String, Integer> checkLength = (s, l) -> s.length() == l;
      System.out.println(checkLength.test("New York City", 13)); //true
   }

}
