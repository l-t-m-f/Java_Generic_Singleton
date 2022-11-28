public class SingletonB extends Multiton {

  protected SingletonB(String secret) {
    super(secret);
  }

  public void DoSomethingElseUnique() {
    System.out.println("And now here's something only SingletonB could print");
  }


}