import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.Class;

abstract public class Multiton {

  private static final HashMap<Class<?>, Multiton> _instances = new HashMap<>(10);
  protected String singletonTester;

  protected Multiton(String secret) {
    singletonTester = secret;
  }

  // Getters

  private static HashMap<Class<?>, Multiton> getInstances() {
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
   * constructor
   */
  public static Multiton GetInstance(Class<?> singletonType, String secret)
      throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
      InvocationTargetException {
    final ReentrantLock multitonLock = new ReentrantLock();
    multitonLock.lock();
    try {
      Multiton instance;
      Constructor<?> singletonConstructor;
      try {
        if (getInstances().containsKey(singletonType) == false) {
          Class<?>[] parameterTypes = { String.class };
          singletonConstructor = singletonType.getDeclaredConstructor(parameterTypes);
          instance = (Multiton) singletonConstructor.newInstance(secret);
          getInstances().put(singletonType, instance);
        }
        return (Multiton) getInstances().get(singletonType);
      } catch (NoSuchMethodException e) {
        System.out.println(e.getClass().getSimpleName() + ": You requested an invalid singleton!");
        return null;
      } catch (InstantiationException e) {
        System.out.println(e.getClass().getSimpleName() + ": You requested an invalid singleton!");
        return null;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getClass().getSimpleName()
            + ": Something went wrong during the creation of the singleton's constructor.");
        return null;
      } catch (SecurityException e) {
        System.out.println(e.getClass().getSimpleName() + ": Uh oh! Something bad happened!");
        return null;
      } catch (IllegalAccessException e) {
        System.out.println(e.getClass().getSimpleName() + ": Uh oh! Something bad happened!");
        return null;
      }
    } finally {
      multitonLock.unlock();
    }
  }
}
