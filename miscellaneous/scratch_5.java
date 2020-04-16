
class Scratch implements Runnable{



  public static void main(String[] args) {

    String s = "1";
    change(s);
    System.out.println(s);

  }

  private static void change(String s) {
    s = "2";
  }

  @Override
  public void run() {
    System.out.println("Turing");
  }
}

