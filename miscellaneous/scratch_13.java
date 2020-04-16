class Scratch {
  public static void main(String[] args) {
    Runnable r = () -> {
      System.out.println(Thread.currentThread().getName());
    };
    r.run();

    Thread thread = new Thread(r);
    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Done");
  }
}