public class SingletonA extends Multiton {

  protected SingletonA(String secret) {
    super(secret);
  }

  protected SingletonA(boolean secret) {
    super("" + secret);
  }

  public void DoSomethingUnique() {
    System.out.println("Something only SingletonA could print");
  }

}