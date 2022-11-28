public class SingletonA extends Multiton {

  protected SingletonA(String secret) {
    super(secret);
  }

  public void DoSomethingUnique() {
    System.out.println("Something only SingletonA could print");
  }

}