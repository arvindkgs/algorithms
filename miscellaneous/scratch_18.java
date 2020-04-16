class Scratch {
    public static void main(String[] args) {
        //Expression : SUM(3, MUL(2,4)) = 11
        String exp = "SUM(3, MUL(2,4))";
        System.out.println(evaluateExpression(exp));
    }

    //'SUM', '3, MUL', '2,4))'
    //SUM, '3', 'MUL', '2', '4))'
    //SUM, 'MUL', '2', '4', '5'

    private static int evaluateExpression(String exp) {
        int result = 0;
        String funs = exp.split("\\(")[0];
        for(int i=funs.length-1;i>=0;i--){
            String[] args = funs[i].split("")
        }
        return result;
    }
}

class Sum extends Function{
    @Override
    public int eval(int x, int y) {
        return x+y;
    }
}

class Multiply extends Function{

    @Override
    public int eval(int x, int y) {
        return x * y;
    }
}

abstract class Function{
    enum FUN_TYPE{SUM, MULTI};

    public abstract int eval(int x, int y);
    public static Function getFunction(String exp){
        //exp = MUL, SUM
        FUN_TYPE type = FUN_TYPE.valueOf(exp);
        switch (type){
            case SUM: return new Sum();
            case MULTI: return new Multiply();
        }
    }
}