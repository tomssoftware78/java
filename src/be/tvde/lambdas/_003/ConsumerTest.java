package be.tvde.lambdas._003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {

   public static void main(String[] args) {
      ConsumerTest consumerTest = new ConsumerTest();
      consumerTest.consumer();
      consumerTest.biConsumer();
   }

   void consumer() {
      Consumer<String> printConsumer = s -> System.out.println(s);
      printConsumer.accept("To be or not to be, that is the question");

      List<String> names = new ArrayList<>();
      names.add("Tom");names.add("Romy");
      names.forEach(printConsumer);
   }

   void biConsumer() {
      var mapCapitalCities = new HashMap<String, String>();

      // BiConsumer<T, U> is a functional interface with 1 abstract method:
      //    void accept(T t, U u);
      BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
      biCon.accept("Dublin", "Ireland");
      biCon.accept("Washington D.C.", "USA");

      BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is the capital of: " + value);
      mapCapitalCities.forEach(mapPrint);
   }

}
