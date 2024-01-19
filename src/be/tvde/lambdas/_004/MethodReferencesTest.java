package be.tvde.lambdas._004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import be.tvde.lambdas._003.PredicateTest;

public class MethodReferencesTest {

   public static void main(String[] args) {
      MethodReferencesTest test = new MethodReferencesTest();
      test.boundMethodReferences();
      test.unboundMethodReferneces();
      test.staticMethodReferences();
      test.constructorMethodReferences();
   }

   void boundMethodReferences() { //instance known at compile-time
      String name = "Tom Van den Eynde";

      Supplier<String> lowerL = () -> name.toLowerCase();
      Supplier<String> lowerMR = name::toLowerCase;

      System.out.println(lowerL.get());
      System.out.println(lowerMR.get());

      Predicate<String> titleL = (title) -> name.startsWith(title);
      Predicate<String> titleMR = name::startsWith;

      System.out.println(titleL.test("Tom"));
      System.out.println(titleMR.test("Tom"));
   }

   void unboundMethodReferneces() { //instance provided at runtime
      Function<String, String> upperL = s -> s.toUpperCase();
      Function<String, String> upperMR = String::toUpperCase;
      System.out.println(upperL.apply("tom"));
      System.out.println(upperMR.apply("tom"));

      BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
      BiFunction<String, String, String> concatMR = String::concat;
      System.out.println(concatL.apply("Sean ", "Kennedy"));
      System.out.println(concatMR.apply("Sean ", "Kennedy"));
   }

   void staticMethodReferences() { //static
      Consumer<List<Integer>> sortL = list -> Collections.sort(list);
      Consumer<List<Integer>> sortMR = Collections::sort;

      List<Integer> numbers = Arrays.asList(2, 1, 5, 4, 9);
      sortL.accept(numbers);
      System.out.println(numbers);

      numbers = Arrays.asList(12, 11, 15, 14, 19);
      sortMR.accept(numbers);
      System.out.println(numbers);
   }

   void constructorMethodReferences() { //constructor
      Supplier<StringBuilder> sbL = () -> new StringBuilder();
      Supplier<StringBuilder> sbMR = StringBuilder::new;
      StringBuilder sb1 = sbL.get();
      sb1.append("lambda version");
      System.out.println(sb1);

      final StringBuilder sb2 = sbMR.get();
      sb2.append("constructor reference");
      System.out.println(sb2);

      Function<Integer, List<String>> alL = x -> new ArrayList<>(x);
      Function<Integer, List<String>> alMR = ArrayList::new;
      List<String> ls1 = alL.apply(10);
      ls1.add("tom");
      System.out.println(ls1);
      List<String> ls2 = alMR.apply(5);
      ls2.add("mario");
      System.out.println(ls2);
   }

}
