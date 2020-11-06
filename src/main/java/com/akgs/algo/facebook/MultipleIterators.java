package com.akgs.algo.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Facebook Round 1
 */

public class MultipleIterators {
    public static void main(String[] args) {
        Values v1 = new Values();
        v1.add(1);
        v1.add(5);
        v1.add(10);
        v1.add(12);
        v1.add(32);
        Values v2 = new Values();
        v2.add(2);
        v2.add(4);
        v2.add(7);
        Iter[] iters = new Iter[2];
        iters[0] = v1;
        iters[1] = v2;
        Iter merged = mergeIters(iters);
        while(merged.hasNext()){
            System.out.println(merged.next());
        }
    }

    private static Iter mergeIters(Iter[] iters) {
        Values result = new Values();
        Integer[] slots = new Integer[iters.length];
        for(int i=0;i<slots.length;i++){
            if(iters[i].hasNext())
                slots[i] = iters[i].next();
            else
                slots[i] = null;
        }
        while(hasMoreElements(slots)) {
            //Atleast one iter has elements
            int min = Integer.MAX_VALUE;
            int minI = -1;
            for(int i=0;i<slots.length;i++){
                if(slots[i] != null && slots[i] < min){
                    min = slots[i];
                    minI = i;
                }
            }
            result.add(min);
            if(iters[minI].hasNext())
                slots[minI] = iters[minI].next();
            else
                slots[minI] = null;
        }
        return result;
    }

    public static boolean hasMoreElements(Integer[] slots){
        boolean hasMore = false;
        for(Integer slot: slots){
            hasMore = hasMore || slot != null;
        }
        return hasMore;
    }

    interface Iter{
        int next();
        boolean hasNext();
    }
    static class Values implements Iter{
        List<Integer> items;
        int curr;
        Values(){
            items = new ArrayList<>();
            curr = 0;
        }
        public void add(int n){
            items.add(n);
        }

        @Override
        public int next() {
            if(curr == items.size())
                throw new ArrayIndexOutOfBoundsException();
            else
                return items.get(curr++);
        }

        @Override
        public boolean hasNext() {
            return items.size() > curr;
        }
    }
}
