class Scratch {
    public static void main(String[] args) {
        Double d = 34.995;
        System.out.println("Math.round: "+(Math.round(d * 100)/100d));
        Double floorD = Math.floor(d * 100)/100d;
        Double res = floorD;
        double diff = d - floorD;
        if (diff >= 0.0049)
            res = floorD + 0.01;
    }
}