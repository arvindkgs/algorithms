import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Scratch {
    static class Pojo implements Comparable<Pojo>{
        String name;
        int count;
        public Pojo(String n, int c){
            name=n;
            count=c;
        }
        public int compareTo(Pojo p) {
            if(p.count < this.count)
                return -1;
            else if(p.count == this.count)
                return 0;
            else
                return 1;
        }
        @Override
        public String toString(){
            return "name: "+this.name+", count: "+this.count;
        }
    }

    public static List<List<Integer>> findBeforeMatrix(List<List<Integer>> after) {
        // Write your code here
        List<List<Integer>> before = new ArrayList<List<Integer>>();
        for(int i=0;i<after.size();i++){
            before.add(new ArrayList<Integer>());
        }
        before.get(0).set(0, after.get(0).get(0));
        for(int i=0;i<after.size();i++){
            for(int j=0;j<after.size();j++){
                if(i != 0 && j != 0){
                    int sum = 0;
                    for(int k = i-1; k>=0; k--){
                        for(int l = j-1; j>=0; l--){
                            sum += before.get(i).get(j);
                        }
                    }
                    before.get(i).set(j, sum-after.get(i).get(j));
                }
            }
        }
        return before;
    }

    public static void main(String[] args) {
        List<List<Integer>> in = new ArrayList<List<Integer>>();
        for(int i=0;i<2;i++)
            in.add(new ArrayList<>());
        in.get(0).add(0,1);
        in.get(0).add(1,2);
        in.get(1).add(0,3);
        in.get(1).add(1,4);
        System.out.println(findBeforeMatrix(in));
    }
}