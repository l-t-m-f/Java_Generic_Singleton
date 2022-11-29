/*
 * Generic Multiton Java by Émile Fréchette.
 * Any suggestions are welcome. v1.1 2022
 */

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class Demo {
  public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

    SingletonA test;
    test = Multiton.GetInstance(SingletonA.class, new Object[] { "hello" });
    if(Objects.isNull(test) == false) test.printTestValue();

    // Doesn't get created because Multiton already contains a SingletonA instance
    SingletonA test2;
    test2 = Multiton.GetInstance(SingletonA.class, new Object[] { "goodbye" });
    if(Objects.isNull(test2) == false) test2.printTestValue();

    // The bellow variant of the GetInstance() calls can specify a custom constructor by specifying the types needed.

    // Doesn't get created because SingletonB doesn't have a (boolean) constructor
    SingletonB test3;
    test3 = Multiton.GetInstance(SingletonB.class, new Class<?>[] { boolean.class }, new Object[] { 999 });
    if(Objects.isNull(test3) == false) test3.printTestValue();

    // Gets created since the previous one didn't
    SingletonB test4;
    test4 = Multiton.GetInstance(SingletonB.class, new Class<?>[] { int.class }, new Object[] { 666 });
    if(Objects.isNull(test4) == false) test4.printTestValue();

    /*
     * It's useful to have a generic singleton factory (aka Multiton) because Singletons
     * are not always exactly the same one from another. This is not exactly a standard pattern of Multiton but serves a similar purpose.
     */
    if(Objects.isNull(test) == false) test.DoSomethingUnique();
    if(Objects.isNull(test3) == false) test3.DoSomethingElseUnique(); // not executed

    // SingletonA notAValidSingleton;
    // Doesn't get created because RandomObj isn't derived from Multiton
    // notAValidSingleton = Multiton.GetInstance(RandomObj.class, "denied");

    // Build error because of type mismatch between generic type of GetInstances and
    // type of the first parameter
    // notAValidSingleton = Multiton.GetInstance(SingletonB.class, "denied");

  }
}
