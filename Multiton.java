import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.Class;

abstract public class Multiton {

  private static final HashMap<Class<?>, Multiton> _instances = new HashMap<>(10);
  protected String _testValue;

  protected Multiton(String testValue) {
    setTestValue(testValue);
  }

  public String getTestValue() {
    return this._testValue;
  }

  private void setTestValue(String value) {
    this._testValue = value;
  }

  private static HashMap<Class<?>, Multiton> getInstances() {
    return _instances;
  }

  public void printTestValue() {
    System.out.println(getTestValue());
  }

  // Uses the default constructor (first listed)
  @SuppressWarnings("Cast")
  public static <T extends Multiton> T GetInstance(Class<T> singletonType, Object[] constructorParameterValues)
      throws InvocationTargetException, InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException {
    final ReentrantLock multitonLock = new ReentrantLock();
    multitonLock.lock();
    try {
      Multiton instance;
      Constructor<?> singletonConstructor;
      try {
        if (getInstances().containsKey(singletonType) == false) {
          singletonConstructor = singletonType.getDeclaredConstructors()[0];
          instance = (Multiton) singletonConstructor.newInstance(constructorParameterValues);
          getInstances().put(singletonType, instance);
        }
        return (T) getInstances().get(singletonType);
      } catch (InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
        System.out
            .println(e.getClass().getSimpleName() + ": Singleton was not acquired and should be discarded (null).");
        return null;
      }
    } finally {
      multitonLock.unlock();
    }
  }

  @SuppressWarnings("Cast")
  public static <T extends Multiton> T GetInstance(Class<T> singletonType, Class<?>[] constructorParameterTypes,
      Object[] constructorParameterValues)
      throws InvocationTargetException, InstantiationException, IllegalAccessException, IllegalArgumentException,
      NoSuchMethodException, SecurityException {
    final ReentrantLock multitonLock = new ReentrantLock();
    multitonLock.lock();
    try {
      Multiton instance;
      Constructor<?> singletonConstructor;
      try {
        if (getInstances().containsKey(singletonType) == false) {
          singletonConstructor = singletonType.getDeclaredConstructor(constructorParameterTypes);
          instance = (Multiton) singletonConstructor.newInstance(constructorParameterValues);
          getInstances().put(singletonType, instance);
        }
        return (T) getInstances().get(singletonType);
      } catch (InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException
          | SecurityException e) {
        System.out
            .println(e.getClass().getSimpleName() + ": Singleton was not acquired and should be discarded (null).");
        return null;
      }
    } finally {
      multitonLock.unlock();
    }
  }
}
