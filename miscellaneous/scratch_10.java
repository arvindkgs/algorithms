import java.nio.file.ClosedWatchServiceException;
import java.util.Arrays;

class Scratch {
  public static void main(String[] args) {
    int[] A = {1,2,3,4};
    System.out.println(test(A));
  }
  public static int test(int[] A){
    // write your code in Java SE 8
    if(A.length == 0){
      return -1;
    }
    else if(A.length == 1){
      return 0;
    }
    else if (A.length == 2){
      if (A[0] == A[1])
        return 1;
      else
        return 0;
    }
    else {
      boolean up = false;
      int valid = 0;
      for(int i=1;i<A.length;i++) {
        if (i > 1) {
          if(A[i-1] > A[i] && up) {
            valid++;
            up = true;
          }
          else if(A[i-1] < A[i] && !up) {
            valid++;
            up = false;
          }
        } else {
          if (A[i-1] > A[i]) {
            up = false;
          } else {
            up = true;
          }
        }
      }
      if (A.length ==  3 ) {
        if(valid == 1) {
          return 0;
        }
        else {
          return 1;
        }
      } else {
        if (valid < (A.length - 3)) {
          return -1;
        }
        else if (valid == A.length - 2){
          return 0;
        }
        else {
          return A.length - 2;
        }
      }
    }
  }
  static class POJO {
    int max;
    int lower;
    int upper;
    POJO(int max, int lower, int upper){
      this.max = max;
      this.lower = lower;
      this.upper = upper;
    }
    public String toString(){
      return "Max: "+this.max+", Lower: "+lower+", Upper: "+upper;
    }
  }
  static class Solution {
    public static int solution(int[] A, int K, int L){
      int sum1 = getMaxConsecutiveSum(A, K, L);
      int sum2 = getMaxConsecutiveSum(A, L, K);
      return sum1 > sum2?sum1: sum2;
    }

    public static int getMaxConsecutiveSum(int[] A, int K, int L){
      POJO kPOJO = getConsecutiveSum(A, K);
      int[] lowerSubset = Arrays.copyOfRange(A, 0, kPOJO.lower);
      int[] upperSubset = Arrays.copyOfRange(A, kPOJO.upper, A.length);
      int[] array1and2 = new int[lowerSubset.length + upperSubset.length];

      System.arraycopy(lowerSubset, 0, array1and2, 0, lowerSubset.length);
      System.arraycopy(upperSubset, 0, array1and2, lowerSubset.length, upperSubset.length);
      POJO lPOJO = getConsecutiveSum(array1and2, L);
      return kPOJO.max + lPOJO.max;
    }

    public static POJO getConsecutiveSum(int[] A, int K){
      int curr_sum = 0;
      int max_sum = 0;
      int kLower = 0;
      int kUpper = 0;
      for(int i=0;i<A.length;i++){
        if (i > (K - 1)) {
          curr_sum = curr_sum - A[i - K] + A[i];
          if (curr_sum > max_sum) {
            max_sum = curr_sum;
            kLower = i - (K - 1);
            kUpper = i;
          }
        } else {
          curr_sum += A[i];
          if (i == (K - 1)) {
            max_sum = curr_sum;
            kLower = 0;
            kUpper = i;
          }
        }
      }
      return new POJO(max_sum, kLower, kUpper);
    }
  }
}