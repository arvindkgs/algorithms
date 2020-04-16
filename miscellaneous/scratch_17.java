class Scratch {
    class Node{
        Node left;
        Node right;
        int data;
    }
    int evalDisjointSum(Node n, int sum){
        if(n != null)
            return sum;
        //include this node
        Node lchild = n.left;
        Node rchild = n.right;
        int includeSum = sum+n.data;
        if(lchild != null){
            includeSum = evalDisjointSum(lchild.left, includeSum);
            includeSum = evalDisjointSum(lchild.right, includeSum);
        }
        if(rchild != null){
            includeSum += evalDisjointSum(rchild.left, includeSum);
            includeSum += evalDisjointSum(rchild.right, includeSum);
        }
        //exclude this node
        int exludeSum = sum;
        if(lchild != null){
            exludeSum += evalDisjointSum(lchild, exludeSum);
        }
        if(rchild != null){
            exludeSum += evalDisjointSum(rchild, exludeSum);
        }
        return includeSum > exludeSum? includeSum: exludeSum;
    }
}