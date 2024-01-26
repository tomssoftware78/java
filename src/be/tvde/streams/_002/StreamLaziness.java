package be.tvde.streams._002;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLaziness {

   public static void main(String[] args) {
      StreamLaziness test = new StreamLaziness();
      //test.test();
      test.test1();
   }

   private void test1() {
      List<String> names = Arrays.asList("April", "Ben", "Charlie", "David", "Benildus", "Christian");
      names.stream()
            .peek(s -> System.out.println(s))
            .filter(s -> {
               System.out.println("Filter1: " + s);
               return s.startsWith("B") || s.startsWith("C");
            })
            .filter(s -> {
               System.out.println("Filter2: " + s);
               return s.length() > 3;
            })
            .limit(1) //intermediate operation that keeps state, in this case to know how many items passed through
            .forEach(s -> System.out.println("Name that reached the end: " + s)); //terminal operation
   }

   private void test() {
      //output will be:
      // map: Alex
      // anyMatch: ALEX
      //Laziness of streams helps reducing the actual number of operations: instead of mapping 4 times + do the anyMatch() = 5 operation in total
      //we process the elements vertically resulting in only 2 operations
      Stream.of("Alex", "David", "April", "Edward")
            .map(s-> {
               System.out.println("map: " + s);
               return s.toUpperCase();
            })
            .anyMatch(s -> {
               System.out.println("anyMatch: " + s);
               return s.startsWith("A");
            });
   }

}
