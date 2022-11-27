import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Multiton
{

  private static final HashMap<String, Multiton> _instances = new HashMap<>();
  private String singletonTester;

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

  public static Multiton GetInstance(String key, String secret)
  {
    final ReentrantLock multitonLock = new ReentrantLock();
    multitonLock.lock();
    try
    {
      Multiton instance;

      if(getInstances().containsKey(key) == false)
      {
        instance = new GameManager(secret);
        getInstances().put(key, instance);
      }
      System.out.println(getInstances().get(key).singletonTester);
      return getInstances().get(key);
    }
    finally
    {
      multitonLock.unlock();
    }
    
  }

}
