import java.util.Scanner;

/**
 * Created by srikanth.kannan on 2/16/15.
 */
public class LinkedListNode {
    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }

    /**
     * reverses the linkedlist
     * @param node
     */
    public static void reverse(LinkedListNode node){
        if(node == null){
            System.out.println("Nothing to reverse. List is null");
        }
        else{
            LinkedListNode currentNode = node; //head of the list
            LinkedListNode nextNode = null;
            LinkedListNode prevNode = null;
            while(currentNode != null){
                nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }//while
        }//else
    }//reverse()

    /**
     * adding item to a linked list. Always to the right
     * @param value
     */
    public void add(int value){
        LinkedListNode node = new LinkedListNode(value);
        LinkedListNode temp = null;
        if(next == null){
            next = node;
        }
        else{
            temp = next;
            temp.next = node;
            next = temp;
        }
    }

    public static void printLinkedList(LinkedListNode node){
        while(node != null){
            System.out.print(node.value + " > ");
            node = node.next;
        }
    }

    public static void main(String args[]){
        LinkedListNode linkedListNode = null;
        System.out.println("Enter a number to add to the linked list. Enter \"quit\" to exit");
        Scanner scanner = new Scanner(System.in);
        int i=0;
        while (true){
            String node = scanner.next();
            if("quit".equalsIgnoreCase(node)){
                if(linkedListNode != null){
                    LinkedListNode.printLinkedList(linkedListNode);
                }
                break;
            }
            int nodeInt = Integer.parseInt(node);
            if(i==0){
                linkedListNode = new LinkedListNode(nodeInt);
            }
            else{
                linkedListNode.add(nodeInt);
            }
            i++;
        }//while
        LinkedListNode.reverse(linkedListNode);
        System.out.println("\nReversing the list\n");
        LinkedListNode.printLinkedList(linkedListNode);

    }
}
