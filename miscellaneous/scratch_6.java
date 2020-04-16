import java.util.HashMap;

class Scratch {
  public static void main(String[] args) {
    System.out.println(contain("a","aaa"));
  }

  private static boolean contain(String text, String note) {
    HashMap<Integer, Integer> textCount = new HashMap<>();
    for(char c : text.toCharArray()){
      if(textCount.get(new Integer(c))==null)
        textCount.put(new Integer(c), 1);
      else
        textCount.put(new Integer(c), textCount.get(new Integer(c))+1);
    }
    for(char c : note.toCharArray()){
      if(textCount.get(new Integer(c))!=null){
        if(textCount.get(new Integer(c)) > 0){
          textCount.put(new Integer(c), textCount.get(new Integer(c))-1);
        }
        else
          return false;
      }
      else{
        return false;
      }
    }
    return true;
  }
}