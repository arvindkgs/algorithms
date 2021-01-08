package com.akgs.algo.vmware;

import java.util.LinkedList;

class Scratch {
    public static void main(String[] args) {
        //LRU cache
        Cache cache = new Cache(3);
        cache.put(1);
        cache.put(2);
        cache.put(3);
        cache.put(4);
        cache.get(2);
        cache.put(4);
        System.out.println("cache = " + cache);
    }
    
    static class Cache{
        LinkedList<Object> list;
        int size;
        public Cache(int size){
            this.size = size;
            list = new LinkedList<>();
        }
        // prev, curr, next
        // Remove from 
        // class Node {
        //  Object data;
        //  Node plink;
        //  Node link;
        // }
        // Hashmap (value, Node)
        // curr = map.get(value);
        // prev = curr.plink
        // next = curr.link;
        // prev.link = next
        // next.plink = prev

        public synchronized void put(Object o){
            if(list.contains(o)){
                list.remove(o);
            }
            if(list.size() >= size){
                //Remove last element
                list.removeLast();
            }
            list.push(o);
        }
        public synchronized Object get(Object o){
            if(!list.contains(o))
                return null;
            list.remove(o);
            list.push(o);
            return o;
        }

        @Override
        public String toString() {
            return "Cache{" +
                    list +
                    '}';
        }
    }
    
    
}