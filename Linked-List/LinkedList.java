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

    public void getHead(){
        System.out.println("Head: "+head.value);
    }

    public void getTail(){
        System.out.println("Tail: "+tail.value);
    }

    public void getLength(){
        System.out.println("Length: "+length);
    }

    // Method adds a new node to the end of the linked list
    public void Append(int value){
        ListNode newNode = new ListNode(value); 
        if(length==0){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode; 
        }
        length+=1; 
    }

    // Method removes the last node from linked lists and returns it
    public ListNode removeLast(){
        if(length==0){
            return null;
        }
        ListNode temp = head; 
        ListNode pre = head; 
        while(temp.next!=null){
            pre=temp;
            temp = temp.next;
        }
        tail=pre; 
        tail.next=null;
        length-=1;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;
    }

    // Method that adds node to the front of the linked list 
    public void Prepend(int value){
        ListNode newNode = new ListNode(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
        length+=1;
    }
}
