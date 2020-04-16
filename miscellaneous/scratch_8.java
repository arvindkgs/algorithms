import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Scratch {
  public static void main(String[] args) {
    List<List<String>> products = new ArrayList<>();
    ArrayList<String> e = new ArrayList<>();
    e.add("10");
    e.add("sale");
    e.add("jan-sale");
    products.add(e);
    e = new ArrayList<>();
    e.add("200");
    e.add("sale");
    e.add("EMPTY");
    products.add(e);
  List<List<String>> discounts = new ArrayList<>();
    e = new ArrayList<>();
    e.add("jan-sale");
    e.add("1");
    e.add("10");
    discounts.add(e);
    e = new ArrayList<>();
    e.add("sale");
    e.add("0");
    e.add("10");
    discounts.add(e);
    System.out.println(Result.findLowestPrice(products, discounts));
  }
}

class Result {

  /*
   * Complete the 'findLowestPrice' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. 2D_STRING_ARRAY products
   *  2. 2D_STRING_ARRAY discounts
   */

  static class Discount{
    String tag;
    String type;
    Integer value;
    public Discount(String tag, String type, String value){
      this.tag = tag;
      this.type = type;
      this.value = Integer.parseInt(value);
    }
  }

  static class Product{
    Integer value;
    List<String> tags = new ArrayList<>();
    Product(List<String> values){
      value = Integer.parseInt(values.get(0));
      for(int i=1;i<values.size();i++)
        tags.add(values.get(i));
    }
  }

  public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {
    // Write your code here
    int minSum = 0;
    Map<String, Discount> discountMap = new HashMap();
    List<Product> productList = new ArrayList<>();
    for(List<String> discount: discounts) {
      discountMap.put(discount.get(0), new Discount(discount.get(0), discount.get(1), discount.get(2)));
    }
    for(List<String> product: products)  {
      productList.add(new Product(product));
    }
    for(Product product: productList) {
      int minValue=Integer.MAX_VALUE;
      int currValue=product.value;
      for(String tag: product.tags) {
        if(!tag.equalsIgnoreCase("EMPTY")){
          Discount d = discountMap.get(tag);
          switch(d.type){
            case "0": currValue = d.value;
              break;
            case "1": currValue = new Double(Math.floor((double)product.value*(100.0-(double)d.value)/100.0)).intValue();
              break;
            case "2": currValue = product.value-d.value;
              break;
          }
        }
        if(currValue<minValue)
          minValue=currValue;
      }
      minSum+=minValue;
    }
    return minSum;
  }

}