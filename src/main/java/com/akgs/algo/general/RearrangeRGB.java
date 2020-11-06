package com.akgs.algo.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given : G,R,R,G,B,B, Output: R,R,G,G,B,B
 * Arrange in R,G,B format
 */
public class RearrangeRGB {
    public static void main(String[] args) {
        String[] input = new String[]{"G","R","R","G","B","B"};
        List<String> list = Arrays.asList(input);
        Collections.sort(list, (o1, o2) -> {
            if(o1.equals(o2)){
                return 0;
            }
            else if(o1.equals("R")){
                return -1;
            }
            else if(o1.equals("G")){
                if(o2.equals("B"))
                    return -1;
                else
                    return 1;
            }
            else {
                return 1;
            }
        });
        list.stream().forEach(System.out::println);
    }
}
