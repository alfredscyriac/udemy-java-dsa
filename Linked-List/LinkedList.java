public class LinkedList {
    // Private instance variables 
    private ListNode head; 
    private ListNode tail; 
    private int length;

    // Linked List Constructor 
    public LinkedList(int value){
        ListNode newNode = new ListNode(value);
        head=newNode;
        tail=newNode;
        length=1; 
    } 

    // Method that prints the entire linked list
    public void PrintList(){
        ListNode current = head; 
        while(current.next!=null){
            System.out.println(current.value);
            current=current.next; 
        }
    }   
}
