package be.tvde.lambdas._001;

public class BasicLambdas {

   public static void main(String[] args) {
      //pre-Java 8
      I i = new I() {

         @Override
         public void m() {
            System.out.println("I::m()");
         }
      };
      i.m();

      I lambdaI = () -> {
         System.out.println("Lambda version");
      };
      I lambdaI2 = () -> System.out.println("Lambda version");
      lambdaI.m();
      lambdaI2.m();
   }
}

interface I {
   void m(); //a functional interface, it had only 1 abstract method
}
