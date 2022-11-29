public class SingletonB extends MultiSingleton {

  protected SingletonB(String secret) {
    super(secret);
  }

  public void DoSomethingElseUnique() {
    System.out.println("And now here's something only SingletonB could print");
  }


}