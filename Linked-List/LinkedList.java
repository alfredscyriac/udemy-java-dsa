public class LinkedList {
    private ListNode head; 
    private ListNode tail; 
    private int length;
    public LinkedList(int value){
        ListNode newNode = new ListNode(value);
        head=newNode;
        tail=newNode;
        length=1; 
    }    
}
