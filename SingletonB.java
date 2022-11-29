public class SingletonB extends Singleton {

  protected SingletonB(String secret) {
    super(secret);
  }

  protected SingletonB(int secret) {
    super("" + secret);
  }

  public void DoSomethingElseUnique() {
    System.out.println("And now here's something only SingletonB could print");
  }


}