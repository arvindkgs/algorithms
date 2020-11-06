package com.akgs.algo.hackerrank;

//HackRank
//Given array - 4123, rotate array - 3213
//Rotate array left by each element in rotate array, and return index of highest position
//Example - Array: 4,1,2,3 , Rotate: 3,2,1,3
// Rotate 3, Array: 3,4,1,2, highest index: 1
// Rotate 2, Array: 2,3,4,1, highest index: 2
// Rotate 1, Array: 1,2,3,4, highest index: 3
// Rotate 3, Array: 3,4,1,2, highest index: 1
// Output : 1,2,3,1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RotateArrayByGivenNoOfRotations {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        //System.out.println(getMaxElementIndexes(a, Arrays.asList(3)));
        int[] res = rotateArray(a, 2);
        for(int val: res){
            System.out.println(val);
        }
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()).stream().map(i -> ((Integer)i).toString()).collect(Collectors.joining(" ")));
    }
    public static List<Integer> getMaxElementIndexes(int[] a, List<Integer> rotate) {
        List<Integer> arr = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<Integer>();
        // Write your code here
        if(arr == null || arr.size()==0 || rotate.size() == 0){
            return result;
        }
        int higestIndex = IntStream.range(0, arr.size())
                .boxed().max(Comparator.comparing(arr::get)).get();
        for(Integer rotateValue: rotate){
            result.add(getRotatedIndex(rotateValue,  higestIndex, arr.size()));
        }
        return result;
    }

    public static int getRotatedIndex(int rotations, int highestIndex, int arraySize){
        return ((arraySize - rotations % arraySize) % arraySize + highestIndex ) % arraySize;
    }

    public static int[] rotateArray(int[] a, int rotations) {
        int[] result = new int[a.length];
        for(int i=0;i<a.length;i++){
            result[getRotatedIndex(rotations, i, a.length)] = a[i];
        }
        return result;
    }
}
