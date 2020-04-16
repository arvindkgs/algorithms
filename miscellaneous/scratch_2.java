class Scratch {
  public static enum VM_SIZE_ENTRY {
    XSMALL("XS", 0),
    SMALL("S", 0),
    MEDIUM("M", 3),
    LARGE("L", 12);

    String shortSize;
    int auxCount;

    VM_SIZE_ENTRY(String shortSize, int auxCount) {
      this.shortSize = shortSize;
      this.auxCount = auxCount;
    }
  }
  public static void main(String[] args) {
    System.out.println(VM_SIZE_ENTRY.XSMALL);
  }
}