package scr.builtinfunction;

import java.util.function.*;

public class BuildInFunctionDemo {
  public static void main(String args[]) {
    Function<String, String> function = (input) -> {System.out.println(input); return "This is Function output";};
    System.out.println(function.apply("This is Function input!"));
    
    Supplier<String> supplier = () -> {return "This is Supplier output";};
    System.out.println(supplier.get());   

    Consumer<String> consumer = (input) -> {System.out.println(input);};
    consumer.accept("This is Consumer input!");
  }
}

