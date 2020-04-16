import java.util.*;

class Scratch {
    public static void main(String[] args) {
        //Two unsorted arrays, find the n largest element from both the arrays
        Integer[] a1 = {1, 3, 5, 60, 10, -1};
        Integer[] a2 = {100, 10, -2, 20, 1};

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        Arrays.asList(a1).stream().forEach(i -> pq.add(i));
        Arrays.asList(a2).stream().forEach(i -> pq.add(i));
        int n = 3;
        Iterator<Integer> iter = pq.iterator();
        int count = 0;
        while(iter.hasNext()){
            count++;
            Integer t = iter.next();
            if(count == n) {
                System.out.println(t);
                break;
            }
        }

        //a1List.stream().forEach(System.out::println);
    }
}