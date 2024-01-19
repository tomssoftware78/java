package be.tvde.lambdas._003;

import java.time.LocalTime;
import java.util.function.Supplier;

public class SupplierTest {

   public static void main(String[] args) {
      SupplierTest st = new SupplierTest();
      st.supplier();
   }

   void supplier() {
      Supplier<StringBuilder> supplier = () -> new StringBuilder();
      System.out.println("Supplier SB: " + supplier.get().append("SK"));

      Supplier<LocalTime> supplier1 = LocalTime::now;
      System.out.println("Supplier time " + supplier1.get());

      Supplier<Double> supplier2 = Math::random;
      System.out.println(supplier2.get());
   }

}
