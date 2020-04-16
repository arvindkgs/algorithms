class Scratch {
    public static void main(String[] args) {
        int[] houses = {1,20,3};
        System.out.println("Max: "+computeMaxDisjointSum(houses));
    }

    private static int computeMaxDisjointSum(int[] houses) {
        return evalDisjointSum(0, houses, 0);
    }

    private static int evalDisjointSum(int i, int[] houses, int sum) {
        //include i
        int includingI = sum+houses[i];
        if(i+2<houses.length)
            includingI = evalDisjointSum(i+2, houses, includingI);
        int excludingI = sum;
        if(i+1< houses.length)
            excludingI = evalDisjointSum(i+1, houses, sum);
        return includingI > excludingI? includingI: excludingI;
    }
}