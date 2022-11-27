import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.Class;

abstract public class Multiton
{

  private static final HashMap<String, Multiton> _instances = new HashMap<>();
  protected String singletonTester;

  protected Multiton(String secret)
  {
    singletonTester = secret;
  }

  // Getters

  private static HashMap<String, Multiton> getInstances()
  {
    return _instances;
  }

  // Class methods

  public void saySecret() {
    System.out.println(singletonTester);
  }

  public static Multiton GetInstance(Class<Multiton> singletonType, String secret) 
    throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    final ReentrantLock multitonLock = new ReentrantLock();
    multitonLock.lock();
    try
    {

      Multiton instance;

      if(getInstances().containsKey(singletonType.getSimpleName()) == false)
      {
          Class<?>[] parameterTypes = { String.class };
          Constructor<Multiton> singletonConstructor = singletonType.getDeclaredConstructor(parameterTypes);
          instance = singletonConstructor.newInstance(secret);
          getInstances().put(singletonType.getSimpleName(), instance);

      }      
      return getInstances().get(singletonType.getSimpleName());
    }
    finally
    {
      multitonLock.unlock();
    }
    
  }

}
