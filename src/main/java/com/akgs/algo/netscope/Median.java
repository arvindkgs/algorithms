package com.akgs.algo.netscope;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median {
    public static void main(String[] args) {
        MedianObj median = new MedianObj(new int[]{1,2,3,4,5});
        System.out.println("median = " + median.getMedian());
        median.addItem(6);
        System.out.println("median = " + median.getMedian());
    }
    static class MedianObj{
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        MedianObj(){
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        }
        MedianObj(int[] ints){
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            for(Integer i : ints){
                addItem(i);
            }
        }

        public void addItem(int ele) {
            if(maxHeap.size() == 0){
                maxHeap.add(ele);
                return;
            }
            if(ele < maxHeap.peek()){
                maxHeap.add(ele);
            }
            else{
                minHeap.add(ele);
            }
            if(Math.abs(minHeap.size() - maxHeap.size()) > 1){
                if(minHeap.size()>maxHeap.size()){
                    maxHeap.add(minHeap.poll());
                }
                else{
                    maxHeap.add(minHeap.poll());
                }
            }
        }
        public double getMedian() {
            if(maxHeap.size() > minHeap.size()){
                return maxHeap.peek();
            }
            else if(maxHeap.size() < minHeap.size()){
                return minHeap.peek();
            }
            else
                return (double)(minHeap.peek() + maxHeap.peek())/2;
        } 
    }
}
