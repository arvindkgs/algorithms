package com.akgs.algo.vmware;

import java.util.*;
import java.util.stream.Collectors;

public class GetMostRequestedProductOrderedAlphabetically {
    static class Entry implements Comparable{
        String key;
        Integer value;
        Entry(Map.Entry<String, Integer> entry){
            key = entry.getKey();
            value = entry.getValue();
        }

        @Override
        public int compareTo(Object o) {
            int comp = this.value.compareTo(((Entry)o).value);
            if(comp == 0){
                return this.key.compareTo(((Entry)o).key);
            }
            return comp;
        }
    }
    public static void main(String[] args) {
        String[] requests = new String[]{"redshoe","blackbag","whitepant","redshoe","yellowbelt","yellowbelt"};
        Map<String, Integer> freqMap = new HashMap<>();
        for(String request: requests){
            int freq = freqMap.containsKey(request)? freqMap.get(request): 0;
            freqMap.put(request, freq);
        }
        List<Entry> entryList = freqMap.entrySet().stream().map(entry -> new Entry(entry)).collect(Collectors.toList());
        Collections.sort(entryList, Collections.reverseOrder());
        System.out.println("entryList = " + entryList.get(0).key);
    }
}
