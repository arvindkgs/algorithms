package com.akgs.algo.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Asked in VMWare Round 1
 */
public class SwitchBinaryDigits {
    public static void main(String[] args) {
        //Given : arr[] - 0...1
        //0101 - 1100
        List<Integer> arr = Arrays.asList(0,1,0,1);
        int lp = 0, up = arr.size()-1;
        while(lp < up) {
            if(arr.get(lp) == 0 && arr.get(up) == 1) {
                //swap
                arr.set(lp, 1);
                arr.set(up, 0);
                lp++;
                up--;
            }
            else {
                if(arr.get(lp) == 1){
                    lp++;
                }
                if(arr.get(up) == 0){
                    up--;
                }
            }
        }
        arr.stream().forEach(System.out::println);
    }
}
