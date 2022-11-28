/*
 * Generic Multiton Java
 * This work is in the public domain and was created by Émile Fréchette.
 * Any suggestions are welcome. 2022
 * 
 */

import java.lang.reflect.InvocationTargetException;

public class Demo {
  public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

    SingletonA test;
    test = Multiton.GetInstance(SingletonA.class, "hola");
    test.saySecret();

    // Doesn't get created because Multiton already contains a SingletonA instance
    SingletonA test2;
    test2 = Multiton.GetInstance(SingletonA.class, "bye bye");
    test2.saySecret();

    SingletonB test3;
    test3 = Multiton.GetInstance(SingletonB.class, "hello");
    test3.saySecret();

    // Doesn't get created because Multiton already contains a SingletonB instance
    SingletonB test4;
    test4 = Multiton.GetInstance(SingletonB.class, "goodbye");
    test4.saySecret();

    /* It's useful to have a generic singleton factory (aka Multiton) because Singletons
    are not always exactly the same one from another. But grouping them under a common management is very useful. */ 
    test.DoSomethingUnique();
    test3.DoSomethingElseUnique();

    
    SingletonA notAValidSingleton;
    // Doesn't get created because RandomObj isn't derived from Multiton
    //notAValidSingleton = Multiton.GetInstance(RandomObj.class, "denied");

    // Build error because of type mismatch between generic type of GetInstances and type of the first parameter
    //notAValidSingleton = Multiton.GetInstance(SingletonB.class, "denied");

  }

}
