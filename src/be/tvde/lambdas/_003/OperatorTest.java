package be.tvde.lambdas._003;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorTest {

   public static void main(String[] args) {
      OperatorTest operatorTest = new OperatorTest();
      operatorTest.unaryOperator();
      operatorTest.binaryOperator();
   }

   void unaryOperator() {
      UnaryOperator<Integer> increment = i -> ++i;

      System.out.println(increment.apply(14));

      UnaryOperator<String> sOperator = name -> "My name is " + name;
      System.out.println(sOperator.apply("Tom"));
   }

   void binaryOperator() {
      BinaryOperator<Double> sum = (d1, d2) -> d1 + d2;

      System.out.println(sum.apply(14.5, 15.5));
   }

}
