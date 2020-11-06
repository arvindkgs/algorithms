package com.akgs.algo.arrays;

public class ReverseWordsInString {
    public static void main(String[] args) {
        //“We are from india” => Reverse each word => Ew era morf aidni
        String str = "We are";
        StringBuffer sb = new StringBuffer(str);
        for(int lp = 0;lp<str.length();lp++){
            int up = lp;
            if(str.substring(up).indexOf(' ') != -1){
                up = str.substring(up).indexOf(' ') - 1;
            }
            else {
                up = str.length() - 1;
            }
            System.out.println("up = " + up);
            int nxt = up;
            while(lp < up){
                Character c = str.charAt(lp);
                sb.setCharAt(lp, str.charAt(up));
                sb.setCharAt(up, c);
                lp++;up--;
            }
            lp = nxt+1;
        }
        System.out.println("sb = " + sb);
    }
}
