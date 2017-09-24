public class AddTwoNum {
    private  int carry = 0;
    private Node sentinel = null;
//    public Node addTwoNumbers(Node l1, Node l2) {
//        int carry = 0;
//        int sum = carry;
//        int digit = 0;
//        Node sentinel = new Node(0);
//        Node result = sentinel;
//        while(l1 != null || l2 != null || carry != 0){
//            if(l1 != null){
//                sum += l1.val;
//                l1 = l1.next;
//            }
//            if(l2 != null){
//                sum += l2.val;
//                l2 = l2.next;
//            }
//            sum += carry;
//            digit = sum % 10;
//            result.next = new Node(digit);
//            result = result.next;
//            if (sum / 10 > 0){
//                carry = sum / 10;
//            }else{
//                carry = 0;
//            }
//            sum = 0;
//            digit = 0;
//        }
//        return sentinel.next;
//    }
    public Node paddingZero(Node n, int num){
        Node sentinel = new Node(0);
        Node zeroList = sentinel;
        for (int i = 1; i < num; i++){
            zeroList.next = new Node(0);
            zeroList = zeroList.next;
        }
        zeroList.next = n;
        return sentinel;
    }
    public Node addTwoNumbersInForward(Node l1, Node l2){

        if (l1.length() > l2.length()){
            l2 = paddingZero(l2,l1.length() - l2.length());
        }else if (l1.length() < l2.length()){
            l1 = paddingZero(l1, l2.length() - l1.length());
        }
        addHelper(l1, l2);
        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = sentinel;
            sentinel = newNode;
        }
        return sentinel;
    }

    public void addHelper(Node l1, Node l2){

        if(l1 == null) return;

        addHelper(l1.next, l2.next);

        int sum = l1.val + l2.val + carry;
        int digit = sum % 10;
        Node newNode = new Node(digit);
        if(sentinel == null){
            sentinel = newNode;
        }else{
            newNode.next = sentinel;
            sentinel = newNode;
        }
        carry = sum / 10;

    }
    public void printNode(Node result){
        while(result != null){
            System.out.println(result.data);
            result = result.next;
        }
    }
    public static void main (String[] args){
        AddTwoNum instance = new AddTwoNum();
        Node l1 = new Node(4);
       l1.next = new Node (0);
//        l1.next.next = new Node (5);
        Node l2 = new Node (9);
        l2.next = new Node(0);
        l2.next.next = new Node(5);
        Node result1 = instance.addTwoNumbersInForward(l1,l2);
        instance.printNode(result1);
    }
}
