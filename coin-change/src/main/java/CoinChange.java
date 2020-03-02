import java.util.*;

public class CoinChange {
    int[] denominations;
    CoinChange(int[] denominations) {
        this.denominations = Arrays.copyOf(denominations, denominations.length);
        Arrays.sort(denominations);
    }
    public int[][] getChangeCombinationsFor(int sum){
        List<Path> paths = new ArrayList<Path>();
        getChange(sum, paths, new Path());
        return returnResult(paths);
    }

    private int[][] returnResult(List<Path> paths) {
        int[][] res = new int[paths.size()][];
        int i=0;
        for( Path path: paths){
            res[i] = new int[path.nodes.size()];
            int j=0;
            for(Node node: path.nodes){
                res[i][j] = node.val;
                j++;
            }
            i++;
        }
        return res;
    }

    private void getChange(int sum, List<Path> paths, Path path) {
        if(sum < denominations[0])
            return;
        for(int i=0;i<denominations.length;i++){
            int remainder = sum - denominations[i];
            if (remainder < 0)
                break;
            if (remainder == 0) {
                path.add(new Node(denominations[i]));
                if (!paths.contains(path)){
                    paths.add(path);
                }
            } else {
                path.add(new Node(denominations[i]));
                getChange(remainder, paths, path);
            }
        }
    }

    class Path {
        private Set<Node> nodes;
        Path(){
            nodes = new HashSet<Node>();
        }
        Path(Path path){
            nodes.addAll(path.nodes);
        }
        public void add(Node node) {
            nodes.add(node);
        }
    }
    class Node {
        int val;
        Node(int d){
            this.val = d;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Node && ((Node)obj).val == val)
                return true;
            else
                return false;
        }
    }
}