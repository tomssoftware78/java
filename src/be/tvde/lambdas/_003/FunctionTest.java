package be.tvde.lambdas._003;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {

   public static void main(String[] args) {
      FunctionTest functionTest = new FunctionTest();
      functionTest.function();
      functionTest.biFunction();
   }

   void function() {
      Function<String, Integer> fn = s -> s.length();
      System.out.println("Function: " + fn.apply("Brussels"));
   }

   void biFunction() {
      BiFunction<String, String, Integer> biFn = (s1, s2) -> s1.length() + s2.length();
      System.out.println("BiFunction: " + biFn.apply("William", "Shakespeare"));

      BiFunction<String, String, String> biFn2 = (s1, s2) -> s1.concat(s2);
      System.out.println((biFn2.apply("William ", "Shakespeare")));
   }

}
