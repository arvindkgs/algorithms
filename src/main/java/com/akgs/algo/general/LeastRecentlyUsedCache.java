package com.akgs.algo.general;

import java.util.HashMap;

public class LeastRecentlyUsedCache {
    static class Node{
        Node previous;
        Node next;
        Object data;
        public Node(Object data) {
            this.data = data;
            previous = next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
    static class DLL{
        Node head;
        Node tail;
        int size;
        DLL(){
            tail = head = null;
            size = 0;
        }
        void add(Object o){
            Node n = new Node(o);
            if(head == null){
                tail = n;
            }
            else{
                head.previous = n;
            }
            n.next = head;
            head = n;
            size++;
        }
        Node remove(){
            //evict last element
            Node evict = tail;
            if(size > 0){
                tail = tail.previous;
                if(tail != null)
                    tail.next = null;
                else{
                    head = null;
                }
                size--;
            }
            return evict;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("head -> ");
            Node curr = head;
            while(curr!=null){
                sb.append(curr.data+" -> ");
                curr = curr.next;
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        System.out.println("LRU");
        LRU cache = new LRU(2);
        cache.add(1);
        cache.add(2);
        cache.add(3);
        cache.add(2);
        System.out.println("cache = " + cache);
    }
    static class LRU{
        int size;
        DLL list;
        HashMap<Object, Node> map;
        public LRU(int size) {
            this.size = size;
            list = new DLL();
            map = new HashMap<>();
        }

        public void add(Object i) {
            Node o = new Node(i);
            if(list.size >= size){
                //Evict
                map.remove(list.remove());
            }
            else if(map.get(i) != null){
                //check item exists
                //remove 
                Node node = map.get(i);
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }
            //add to front
            list.add(o);
            map.put(i,o);
        }

        @Override
        public String toString(){
            return list.toString();
        }
        
        /*public Object get(Object i) {
            
        }*/
    }
}
