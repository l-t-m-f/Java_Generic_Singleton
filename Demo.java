import java.lang.reflect.InvocationTargetException;

public class Demo
{
  public static void main(String[] args) 
    throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException
  {


      SingletonA test;
      test = (SingletonA)Multiton.GetInstance("SingletonA", "hola");
      test.saySecret();
      //Doesn't get created because Multiton already contains a SingletonA instance
      SingletonA test2;
      test2 = (SingletonA)Multiton.GetInstance("SingletonA", "bye bye");
      test2.saySecret();

      SingletonB test3;
      test3 = (SingletonB)Multiton.GetInstance(SingletonB.class.getSimpleName(), "hello");
      test3.saySecret();
      //Doesn't get created because Multiton already contains a SingletonB instance
      SingletonB test4;
      test4 = (SingletonB)Multiton.GetInstance(SingletonB.class.getSimpleName(), "goodbye");
      test4.saySecret();

      //Doesn't get created because RandomObj isn't derived from Multiton
      SingletonA notAValidSingleton;
      notAValidSingleton = (SingletonA)Multiton.GetInstance("RandomObj", "denied");

  }

}

