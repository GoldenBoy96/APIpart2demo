package scr.defaultandstatic;

public class DefaultAndStaticDemo { 
  public static void main(String[] args) {
    StaticDemo staticDemo = () -> {System.out.println("This is regular method!");};  
    staticDemo.regularMethod();
    //staticDemo.staticMethod(); //compile error
    StaticDemo.staticMethod();

    DefaultDemo defaultDemo = () -> {System.out.println("This is regular method!");};
    defaultDemo.regularMethod();
    defaultDemo.defaultMethod();
    //DefaultDemo.defaultMethod(); //compile error
  }  
}

@FunctionalInterface
interface StaticDemo {
  public void regularMethod();
  public static void staticMethod(){
    System.out.println("This is static method!");
  };
}

@FunctionalInterface
interface DefaultDemo {
  public void regularMethod();
  default void defaultMethod(){
    System.out.println("This is default method!");
  };
}