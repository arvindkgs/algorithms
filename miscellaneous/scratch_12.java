class Scratch {
  public static void main(String[] args) {
    int colNum = 28;
    printExcelColumn(colNum);
  }

  private static void printExcelColumn(int colNum) {
    //28 = BA , 28/26 = 2 => 'a', 28%26=2 => 'b'
    // 2222 = 2*(3**10) +  2*(2**10) + 2*(1*10) + 2*(0**10)
    // AB = (26**1)*1 + (26**0)*2 = 28
    //Given 1, Print A, B=2, etc
    //char base_codes = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',]
    int num = colNum;
    StringBuffer sb = new StringBuffer();
    while(num > 0){
      int r = num % 26; //1
      sb.append((char)('a' + (r-1)));
      num = (num-r) / 26;
    }
    System.out.println(sb);
  }
}