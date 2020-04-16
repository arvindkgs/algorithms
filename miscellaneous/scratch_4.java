import java.io.FileNotFoundException;

class Scratch {
  public static void main(String[] args) {
    try {
      throwRunTimeException();
    } catch (RuntimeException e) {
      if (e.getCause() instanceof FileNotFoundException){
        System.out.println("Caught FileNotFoundException");
      }
    }
  }

  private static void throwRunTimeException() {
    throw new RuntimeException(new FileNotFoundException());
  }
}