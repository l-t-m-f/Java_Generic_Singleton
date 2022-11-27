import java.lang.Class;
import java.lang.reflect.InvocationTargetException;

public class Demo
{
  public static void main(String[] args) 
    throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException
  {
      SingletonA test;
      test = (SingletonA)Multiton.GetInstance((Class<Multiton>)Class.forName("SingletonA"), "hola");
      test.saySecret();
      SingletonA test2;
      test2 = (SingletonA)Multiton.GetInstance((Class<Multiton>)Class.forName("SingletonA"), "bye bye");
      test2.saySecret();

      SingletonB test3;
      test3 = (SingletonB)Multiton.GetInstance((Class<Multiton>)Class.forName("SingletonB"), "hello");
      test3.saySecret();
      SingletonB test4;
      test4 = (SingletonB)Multiton.GetInstance((Class<Multiton>)Class.forName("SingletonB"), "goodbye");
      test4.saySecret();
  }

}