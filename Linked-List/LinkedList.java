import org.w3c.dom.Node;

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

    // Method that removes the first node and returns it
    public ListNode removeFirst(){
        if(length==0){
            return null;
        }
        ListNode temp = head; 
        head=head.next; 
        temp.next=null;
        length-=1; 
        // Checks for length == 1 originally but became 0
        if(length==0){
            tail=null;
        }
        return temp;
    }

    // Method that returns the node at a specific index passed in as parameter 
    public ListNode get(int index){
        if(index<0 || index>= length){
            return null;
        }
        ListNode temp = head; 
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    // Method that sets a specific node at a specific index to a new value
    public boolean set(int index, int value){
        ListNode temp = get(index);
        if(temp!=null){
            temp.value=value;
            return true;
        }
        else{
            return false;
        }
    }

    // Method that allows a new node to be inserted at any index
    public boolean insert(int index, int value){
        if(index<0 || index>length){
            return false;
        }
        if(index==0){
            Prepend(value);
            return true;
        }
        if(index==length){
            Append(value);
            return true;
        }
        ListNode newNode = new ListNode(value);
        ListNode prev = get(index-1);
        newNode.next=prev.next;
        prev.next=newNode;
        length+=1;
        return true;
    }

    // Method that removes a node a specific index
    public ListNode remove(int index){
        if(index<0 || index>=length){
            return null;
        }
        if(index==0){
            return removeFirst();
        }
        if(index==length-1){
            return removeLast();
        }
        ListNode prev = get(index-1);
        ListNode temp = get(index);
        prev.next=temp.next;
        temp.next=null;
        length-=1;
        return temp; 
    }

    // Method that reverses the order of the linked list
    public void reverse(){
        ListNode temp = head;
        head=tail;
        tail=temp;
        ListNode after = temp.next;
        ListNode before = null;
        for(int i=0;i<length;i++){
            after=temp.next;
            temp.next=before;
            before=temp; 
            temp=after;
        }
    }

    // Method that returns the node in the middle without using length
    // Hare and Tortise Algorithm
    public ListNode findMiddleNode(){
	    ListNode slow = head; 
	    ListNode fast = head; 
	    while(fast!=null && fast.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    return slow; 
	}
}
