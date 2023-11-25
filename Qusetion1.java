class DoublyLinkedList {    
    class Node{  
        int data;  
        Node prev;  
        Node next;  
   
        public Node(int data) {  
            this.data = data;  
        }  
    }  
    Node head, tail = null;  
    
    public void traverse() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("Doubly linked list is empty");  
            return;  
        }  
        while(current != null) {  
            System.out.print(current.data + " <-> ");  
            current = current.next;  
        }  
    } 
     
    public void insert(int data) {  
        Node newNode = new Node(data);  
   
        if(head == null) {  
            head = tail = newNode;  
            head.prev = null;   
            tail.next = null;  
        }  
        else {  
            tail.next = newNode;   
            newNode.prev = tail;  
            tail = newNode;
            tail.next = null;  
        }  
    }
    
    public void insert(int data, int pos) {
    	 Node newNode = new Node(data);
    	 Node cr = head;
    	 int c = 0;
    	 while(cr.next != null) {
    		 c++;
    		 cr = cr.next;
    	 }
    	 
    	 if(head == null) {  
             head = tail = newNode;  
             head.prev = null;   
             tail.next = null;  
         } else if(pos == c) {
        	 tail.next = newNode;
        	 newNode.prev = tail;
        	 tail = newNode;
         }
    	 else if(pos == 0) {
    		newNode.next = head;
    		head.prev = newNode;
    		head = newNode;
    		head.prev = null;
    		 
    	 } else {
    		 Node curr = head;
    		 int count = 1;
    		 while(curr.next != null) {
    			 if(count == pos) {
    				 curr.next.prev = newNode; 
    				 newNode.next = curr.next;
    				 newNode.prev = curr;
    				 curr.next = newNode; 
    				 
    				 break;
    			 }
    			 count++;
    			 curr = curr.next;
    		 }
    	 }
    }
    
    public void delete(int data) {
    	Node cr = head;
    	if(head.data == data) {
			head = head.next;
			head.prev = null;
			
		} else if(tail.data == data) {
			tail = tail.prev;
			tail.next = null;
			
		}else {
			while(cr.next != null) {
	    		 if(cr.data == data) {
	    			 cr.prev.next = cr.next;
	    			 cr.next.prev = cr.prev.next;
	    			 cr.next = null;
	    			 cr.prev = null;
	    		 }
	    		 cr = cr.next;
	    	 }
		}
    }
    
    public Node reverse(Node node) {
    	 if (node == null) 
    	     return null;
    	 
    	 Node temp = node.next; 
    	 node.next = node.prev; 
    	 node.prev = temp; 
    	 
    	 if (node.prev == null) 
    	     return node; 
    	 
    	 return reverse(node.prev); 
    }
}
public class Question1{
    public static void main(String[] args) {  
 
        DoublyLinkedList dll = new DoublyLinkedList();  
         
        dll.insert(10);  
        dll.insert(20);  
        dll.insert(30);  
        dll.insert(40);  
        dll.insert(50);  
        System.out.println("Double Linked List is: ");
        dll.traverse(); 
        System.out.println();
        System.out.println("Double Linked List Insert 15 at pos 2: ");
        dll.insert(15, 2);
        
        dll.traverse(); 
        System.out.println();
        
        System.out.println("Double Linked List delete 10: ");
        dll.delete(10);
        
        dll.traverse();
        System.out.println();
        
        System.out.println("Reverse of Double Linked List is: ");
        dll.head = dll.reverse(dll.head);
        
        dll.traverse(); 
        System.out.println();
        
        
    }  
}  
