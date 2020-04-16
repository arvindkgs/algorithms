class Scratch {
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        //ip: node, val
        //root(2)->20->10->6->8->12
        //l -> {}
        //op: 2->6->8->10->12->20
        //curr=root
        //curr.data < val
        Node root = new Node(2);
        Node sortedList = sortOnNode(root, 10);
    }

    private static Node sortOnNode(Node node, int i) {
        Node curr = node;
        Node prev = null;
        Node smallerList = null;
        while (curr != null){
            if(curr.data < i){
                if(smallerList == null)
                    smallerList = curr;
                else{
                    smallerList.next = curr;
                }
                if(prev != null){
                    prev.next = curr.next;
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }
}