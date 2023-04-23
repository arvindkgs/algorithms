package com.akgs.algo.general;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Ascii To Int solution similar to C
 */
public class StringToInteger {
  public static void main(String[] args) {
    System.out.println(
        myAtoi(
            "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
  }

  public static int myAtoi(String s) {
    Long res = 0L;
    List<Character> chars = new ArrayList();
    int l = 0;
    while (l < s.length() && s.charAt(l) == ' ') l++;
    boolean positive = true;
    if (l == s.length()) return res.intValue();
    if (l < s.length() && s.charAt(l) == '-') {
      positive = false;
      l++;
    } else if (l < s.length() && s.charAt(l) == '+') {
      l++;
    }
    Pattern digit = Pattern.compile("\\d");
    boolean nonZero = false;
    for (int i = l; i < s.length(); i++) {
      char c = s.charAt(i);
      if (digit.matcher("" + c).matches()) {
        if (c != '0' && !nonZero) nonZero = true;
        if (c != '0' || nonZero) chars.add(c);
      } else {
        break;
      }
    }
    long base = 1l;
    if (chars.size() > 10) {
      if (positive) {
        return Integer.MAX_VALUE;
      } else {
        return Integer.MIN_VALUE;
      }
    }
    for (int i = chars.size() - 1; i >= 0; i--) {
      res += (chars.get(i) - 48) * base;
      base = base * 10;
      if (res >= Integer.MAX_VALUE && positive) {
        return Integer.MAX_VALUE;
      }
      Long INTEGER_MIN_VALUE = (long) Integer.MAX_VALUE;
      INTEGER_MIN_VALUE += 1L;
      if (res >= INTEGER_MIN_VALUE && !positive) {
        return Integer.MIN_VALUE;
      }
    }
    if (!positive) res = res * -1;
    return res.intValue();
  }
}
