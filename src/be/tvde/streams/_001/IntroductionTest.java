package be.tvde.streams._001;

import java.util.Arrays;
import java.util.List;

public class IntroductionTest {

   public static void main(String[] args) {
      IntroductionTest test = new IntroductionTest();
      test.test();
   }

   private void test() {
      List<Double> temps = Arrays.asList(98.4, 100.2, 87.9, 102.8);
      System.out.println("Number of temps > 100 is: " +
                         temps.stream()
                               .peek(d -> System.out.println("Before filter: " + d))
                               .filter(t -> t > 100)
                               .peek(d -> System.out.println("After filter: " + d))
                               .count()
                         );
   }

}
