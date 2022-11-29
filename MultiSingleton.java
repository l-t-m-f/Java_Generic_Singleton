import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.Class;

abstract public class MultiSingleton {

  private static final HashMap<Class<?>, MultiSingleton> _instances = new HashMap<>(10);
  protected String singletonTester;

  protected MultiSingleton(String secret) {
    singletonTester = secret;
  }

  // Getters

  private static HashMap<Class<?>, MultiSingleton> getInstances() {
    return _instances;
  }

  // Class methods

  public void saySecret() {
    System.out.println(singletonTester);
  }

  /*
   * Method to get a specific singleton by class name. If the name is not a valid
   * child of Multiton,
   * the function will return null!
   * Secret can be changed for whatever state to pass into the Singleton's
   * constructor. Doesn't have to be a String necessarely.
   */
  @SuppressWarnings("Cast")
  public static <T extends MultiSingleton> T GetInstance(Class<T> singletonType, String secret) 
    throws InvocationTargetException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException {
    final ReentrantLock multitonLock = new ReentrantLock();
    multitonLock.lock();
    try {
      MultiSingleton instance;
      Constructor<?> singletonConstructor;
      try {
        if (getInstances().containsKey(singletonType) == false) {
          singletonConstructor = singletonType.getDeclaredConstructors()[0];
          instance = (MultiSingleton) singletonConstructor.newInstance(secret);
          getInstances().put(singletonType, instance);
        }
        return (T) getInstances().get(singletonType);
      }
      catch (InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e)
      {
        System.out.println(e.getClass().getSimpleName() + ": Singleton was not acquired and should be discarded (null).");
        return null;
      }
    } finally {
      multitonLock.unlock();
    }
  }
}
