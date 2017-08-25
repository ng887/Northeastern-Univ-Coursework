package LinkedList;

import java.util.List;

/**
 * Created by neha on 2/28/2017.
 */
public class LinkedList {

    public Node head;
    // public Node tail ;
    public int size ;

    /*  Constructor  */
    public LinkedList()
    {
        head = null;
        //tail = null;
        size = 0;
    }

    public void printLL(Node head){
        while(head!= null){
            System.out.print(head.getElement() + "-->");
            head = head.getNext();
        }
        System.out.print("null");
    }

    public boolean isEmpty()
    {
        return head == null;
    }
    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }

    /* INSERT IN LINKED LIST */

    /*Insert at Head */
    public void insertHead(int data){

        Node newNode = new Node(data);

        if (head==null){
            head = newNode;
            return;
        }
        else{
            newNode.next= head;
            head = newNode;
        }

    }

    /*Insert at Tail */
    public void insertTail(int data){

        Node newNode = new Node(data);

        if (head==null){
            head = newNode;
            return;
        }

        Node last =  head;
        newNode.next= null;

        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;
        return;
    }


    /*Reverse a Linked List */
    public Node reverseLinkList(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    /* Find nth node from last - Using 2 pointers */
    /*Time Complexity: O(n) where n is length of LL */
    public void nthFromLast(int n){
        Node fast = head;
        Node slow = head;
        int count = 0;

        if( head != null){
            while (count < n){
                if(fast == null){ // if n is greater than size of the list
                    System.out.println("The size of the list is less than " + n);
                    return;
                }
                fast = fast.next;
                count ++;
            }

            while(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
            System.out.println("The " + n + "th element from the last is " + slow.data);
        }


    }

     /* Find nth node- */
     /*Time Complexity: O(n) where n is length of LL */
     public void nthFromStart(int n) {
         Node curr = head;
         int count = 0;

         if(head != null){
             while (curr != null){
                 if (count == n){
                     System.out.println("The " + n + "th element is " + curr.data);
                     return;
                 }
                 else{
                     count++;
                     curr=curr.next;
                 }
             }
             System.out.println("Not a valid node number");
         }


     }

     /* find middle element */
     public void printMiddleElement(){
         Node fast = head;
         Node slow = head;

         if (head != null){
             while (fast.next != null && fast.next.next != null){
                 slow = slow.next;
                 fast = fast.next.next;
             }
             System.out.println("\nThe middle element of the linked list is: " + slow.data);
         }

     }

     /* Check if linked list is cyclic & Break the cycle in cyclic linked list*/
     //If we have 2 pointers - fast and slow. It is guaranteed that the fast one will meet the slow one if there exists a circle.
    public boolean isCyclic(){
        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                System.out.println("\n\nIs the linked list Cyclic? ");
                System.out.println("Yes, the start of the cycle is " + slow.data);

                System.out.println("\n\nBreak the cycle ");
                breakCycle(slow, head);
                return true;
            }
        }
        return false;
    }

    /*CHECK IT */
    private void breakCycle(Node slow, Node head){
        Node ptr1 = slow;
        Node ptr2 = slow;

        ptr2 = ptr2.next;
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
         ptr2.next = null;
    }

    /* Intersection point of two linked lists */
    /*Time Complexity: O(m+n)*/
    private int getLength(Node head){
        Node current = head;
        int count = 0;

        while(current != null){
            count ++;
            current = current.next;
        }
        return count;
    }


    public int getIntersectionNode(Node head1, Node head2){
        int count1 = getLength(head1);
        int count2 = getLength(head2);
        int d;

        if(count1 > count2){
            d = count1-count2;
            return getIntersectionNodeHelper(d,head1,head2);
        }else{
            d=count2-count1;
            return getIntersectionNodeHelper(d,head2,head1);
        }

    }

    private int getIntersectionNodeHelper(int d, Node node1, Node node2) {
        Node current1 = node1;
        Node current2 = node2;

        for( int i =0 ; i< d ; i++){
            if(current1 == null){
                return -1;
            }
            current1 = current1.next;
        }

        while(current1 !=  null && current2 != null){
            if(current1.data == current2.data){
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    /*Merge two sorted Linked List - Recursively */
    public Node mergeSortedLinkedLists(Node head1, Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        if(head1.data < head2.data){
            head1.next = mergeSortedLinkedLists(head1.next,head2);
            return head1;
        }
        else{
            head2.next = mergeSortedLinkedLists(head1,head2.next);
            return head2;
        }
    }

    /*Reverse a Linked List in groups of  k elements */
    /*Time Complexity: O(n) where n is the number of nodes in the given list.*/
    public Node reversekNodesInLinkedList(Node head, int k){
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;

        while (count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count ++;
        }
        if(next != null){
            head.next = reversekNodesInLinkedList(next,k);
        }
        return prev;
    }

    /*Intersection (list1, list2)  No Duplicates -Initialize result list as NULL. Traverse list1 and look for its each element in list2,
    if the element is present in list2, then add the element to result.
     */
    boolean isPresent(Node head, int data){
        Node node = head;
        while(node != null){
            if (node.data == data){
                return true;
            }else{
                node = node.next;
            }
        }
        return false;
    }

    public void getIntersection(Node head1, Node head2){
        Node node = head1;

        while(node != null) {
            if (isPresent(head2, node.data)){
                insertHead(node.data);
            }
                node = node.next;

        }
    }

    /*Union (list1, list2) No Duplicates:
    Initialize result list as NULL. Traverse list1 and add all of its elements to the result.
    Traverse list2. If an element of list2 is already present in result then do not insert it to result, otherwise insert. */
    void getUnion(Node head1, Node head2)
    {
        Node node1 = head1, node2 = head2;

        //insert all elements of list1 in the result
        while (node1 != null)
        {
            insertHead(node1.data);
            node1 = node1.next;
        }

        // insert those elements of list2 that are not present
        while (node2 != null)
        {
            if (!isPresent(head, node2.data))
                insertHead(node2.data);
                node2 = node2.next;
        }
    }

    /*Delete a node in middle of Linked List */
    public Node deleteMiddleNode(Node head){
        if(head == null){
            return null;
        }
        Node fast =head;
        Node slow = head;
        Node prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    /*Check if Palindrome */
    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node middleHead = slow.next;
        //slow.next = null;
        Node p = reverseLinkList(middleHead);
        Node q = head;

        while(p != null){
            if(p.data != q.data){
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    /*Delete a node with only access to it and not the head*/
    public void deleteNodeNoAccessToHead(Node node){

       Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
    }

    /*Alternating Split in Linked List */
    static Node headListA = null;
    static Node headListB = null;
    public void AlternateSplit(Node head) {
        Node curr = head;


        if (curr == null && curr.next == null) {
            return;
        }

        headListA = curr;
        headListB = curr.next;

        while (curr != null && curr.next != null) {
            Node temp = curr.next;
            curr.next = temp.next;
            if (curr.next != null && curr.next.next != null) {
                temp.next = curr.next.next;
            } else {
                temp.next = null;
                return;
            }
            curr = curr.next;
        }

    }

    /*Pair Wise Swap */
    public Node pairWiseSwap(Node head){
        Node node = head;

        if(node == null || node.next == null){
            return null;
        }

        Node prev = node;
        Node cur = node.next;
        node = cur;
        while(true){
            Node next = cur.next;
            cur.next = prev;
            if(next == null || next.next ==null){
                prev.next = next;
                break;
            }
            prev.next = next.next;
            prev = next;
            cur = prev.next;

        }
        return node;
    }

    /*Delete a node in Linked List */
    public void deleteNode(int value){
        Node cur = head;
        Node prev = null;

        if( cur != null && cur.data == value){
            head = cur.next;
            return;
        }

        while ( cur != null && cur.data != value){
            prev = cur ;
            cur = cur.next;
        }
        if(cur == null){
            return;
        }else{
            prev.next = cur.next;
        }
    }

    public static void main(String[] args) {

        LinkedList cyclicList = new LinkedList();

        cyclicList.insertHead(10);
        cyclicList.insertHead(4);
        cyclicList.insertHead(15);
        cyclicList.insertHead(20);
        cyclicList.insertHead(50);

        LinkedList list = new LinkedList();
        list.insertHead(5);
        list.insertHead(4);
        list.insertHead(6);
        list.insertHead(9);
        System.out.println("Insert at head:");
        list.printLL(list.head);


        System.out.println("\n\nInsert at tail:");
        list.insertTail(15);
        list.insertTail(14);
        list.insertTail(16);
        list.insertTail(19);
        list.printLL(list.head);


        LinkedList list1 = new LinkedList();
        list1.insertHead(9);
        list1.insertHead(6);
        list1.insertHead(4);
        list1.insertHead(5);
        list1.insertHead(3);
        list1.insertHead(2);
        list1.insertHead(1);

        LinkedList sortedList1 = new LinkedList();
        sortedList1.insertHead(3);
        sortedList1.insertHead(4);
        sortedList1.insertHead(5);
        sortedList1.insertHead(6);
        sortedList1.insertHead(9);


        LinkedList sortedList2 = new LinkedList();
        sortedList2.insertHead(5);
        sortedList2.insertHead(10);
        sortedList2.insertHead(11);
        sortedList2.insertHead(18);
        sortedList2.insertHead(21);

        System.out.println("\n\nReverse a linked list:");
        list.head =  list.reverseLinkList(list.head);
        list.printLL(list.head);

        System.out.println("\n\nnth node from last");
        list.nthFromLast(5);

        System.out.println("\nnth node from start");
        list.nthFromStart(3);

        System.out.println("\nThe middle element of the linked list");
        list.printLL(list.head);
        list.printMiddleElement();

        System.out.println("\nIs the linked list Cyclic? " + cyclicList.isCyclic());
        cyclicList.printLL(cyclicList.head);

        cyclicList.head.next.next.next.next.next = cyclicList.head.next.next;
       // System.out.println("Is the linked list Cyclic? " + cyclicList.isCyclic());
        cyclicList.isCyclic();

        System.out.println("After breaking the cycle the linked list is:");
        cyclicList.printLL(cyclicList.head);

        System.out.println("\n\nGet intersection of two LinkedList");
        System.out.println("List01: "); list.printLL(list.head);
        System.out.println("\nList02: "); list1.printLL(list1.head);
        System.out.println("\nIntersection point is:" + list.getIntersectionNode(list.head , list1.head));

        System.out.println("\n\nReverse k nodes in a LinkedList");
        list.printLL(list.head);
        System.out.println();
        list.printLL(list.reversekNodesInLinkedList(list.head,3));

        System.out.println("\n\nGet intersection of 2 Linked Lists");
        list.printLL(list.head);
        System.out.println();
        list1.printLL(list1.head);
        System.out.println("\nIntersection List is:");
        LinkedList intersection = new LinkedList();
        intersection.getIntersection(list.head,list1.head);
        intersection.printLL(intersection.head);


        System.out.println("\n\nGet Union of 2 Linked Lists");
        list.printLL(list.head);
        System.out.println();
        list1.printLL(list1.head);
        System.out.println("\nUnion List is:");
        LinkedList union = new LinkedList();
        union.getUnion(list.head,list1.head);
        union.printLL(union.head);


        System.out.println("\n\nDelete middle of Linked List");
        list.printLL(list.head);
        System.out.println();
        list.printLL(list.deleteMiddleNode(list.head));

        System.out.println("\n\nCheck if the list is palindrome");
        LinkedList plist = new LinkedList();
        plist.insertHead(10);
        plist.insertHead(3);
        plist.insertHead(5);
        plist.insertHead(3);
        plist.insertHead(10);

        plist.printLL(plist.head);
        System.out.println();
        System.out.println(plist.isPalindrome(plist.head));

        System.out.println("\n\nDelete a node with no access to head");
        plist.printLL(plist.head);
        plist.deleteNodeNoAccessToHead(plist.head.next.next);
        System.out.println();
        plist.printLL(plist.head);

        System.out.println("\n\nAlternate Split of Linked List");
        list1.printLL(list1.head);
        list1.AlternateSplit(list1.head);
        System.out.println();
        list1.printLL(headListA);
        System.out.println();
        list1.printLL(headListB);


        System.out.println("\n\nPairwise swap");
        list1.printLL(list1.head);
        System.out.println();
        list1.printLL(list1.pairWiseSwap(list1.head));

        int value = 2;
        LinkedList list2 = new LinkedList();
        list2.insertHead(9);
        list2.insertHead(6);
        list2.insertHead(4);
        list2.insertHead(5);
        list2.insertHead(3);
        list2.insertHead(2);
        list2.insertHead(1);
        System.out.println("\n\nDelete a node with value: " + value);
        list2.printLL(list2.head);
        System.out.println();
        list2.deleteNode(value);
        list2.printLL(list2.head);
    }

}