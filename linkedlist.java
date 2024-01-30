// Linked List Implementation

import java.util.*;

class linkedlist {
    public static void main(String[] args) {
        System.out.print("\nLINKED LIST IMPLEMENTATION\n\n");

        linked_list mylist = new linked_list();

        int ch = -1;

        while (ch != 0) {
            System.out.println("Please select an operation to perform on the linked list: ");
            System.out.println("1. To insert in the begining");
            System.out.println("2. To insert at the end of the list");
            System.out.println("3. To print the list");
            System.out.println("4. To insert into a middle position");
            System.out.println("5. To delete a node from the begining of the list");
            System.out.println("6. To delete a node from teh middle of the list");
            System.out.print("\nEnter your choice: ");

            Scanner sc = new Scanner(System.in);
            ch = sc.nextInt();

            if (ch == 0) {
                System.out.println("\nExiting...");
            }
            else if (ch == 1) {
                System.out.print("\nEnter an integer to insert in the begining: ");
                int item = sc.nextInt();
                mylist.insert_begin(item);
                System.out.println("\nSuccess!\n");
            }
            else if (ch == 2) {
                System.out.print("\nEnter an integer to insert in the end: ");
                int item = sc.nextInt();
                mylist.insert_end(item);
                System.out.println("\nSuccess!\n");
            }
            else if (ch == 3) {
                System.out.println("\nThe list is: ");
                mylist.display_list();
            }
            else if (ch == 4) {
                System.out.print("\nEnter a position(starting from 0) to insert at: ");
                int pos = sc.nextInt();
                System.out.print("\nEnter an integer to insert in the middle: ");
                int item = sc.nextInt();
                mylist.insert_middle(pos, item);
            }
            else if (ch == 5) {
                mylist.delete_front();
            }
            else if (ch == 6) {
                System.out.print("\nEnter a position(starting from 0) which you would like to delete node form: ");
                int pos = sc.nextInt();
                mylist.delete_middle(pos);
            }
            else {
                System.out.println("\nINVALID INPUT!\n");
            }
        }
    }
}


class linked_list {
    class node {
        int data;
        node next;
        node() {
            data = 0;
            next = null;
        }
    }
    node startptr = null;

    
    void insert_begin(int item) {
        node newNode = new node(); // creates new node

        if (startptr == null) {
            newNode.data = item;
            newNode.next = null;
            startptr = newNode;
        }
        else {
            newNode.data = item;
            newNode.next = startptr;
            startptr = newNode;
        }
    }


    void insert_end(int item) {
        node newNode = new node();
        node q = startptr;

        while (q.next != null) {
            q = q.next;
        }

        newNode.data = item;
        newNode.next = null;
        q.next = newNode;
    }


    void display_list() {
        node q = startptr;

        if (startptr == null) {
            System.out.println("List is empty");
        }
        else {
            while (q != null) {
                System.out.print(q.data + " ");
                q = q.next;
            }
        }

        System.out.println("\n");
    }


    void insert_middle(int pos, int item) {
        if (pos == 0) {
            insert_begin(item);
        }   
        else {
            if(startptr == null) {
                System.out.println("\nUNSUCCESSFUL: List not created!\n");
                return;
            }
            node current = startptr;
            node prev = null;

            for (int i = 0; i < pos; i++) {
                prev = current;
                current = current.next;

                if (current == null) {
                    System.out.println("\nUNSUCCESSFUL: Position is out of bounds!\n");
                    return;
                }
            }

            node newNode = new node();
            newNode.data = item;
            
            newNode.next = current;
            prev.next = newNode;
            System.out.println("\nSuccess!\n");  
        }
    }


    void delete_front() {
        node current = startptr;
        startptr = current.next;
        System.out.println("\nSuccess\n");
    }


    void delete_middle(int pos) {
        node current = startptr;
        node prevNode = null;
        
        for (int i = 0; i < pos; i++) {
            prevNode = current;
            current = current.next;
            
            if (current == null) {
                System.out.println("\nUnsuccessul! Position is out of bounds!\n");

                return;
            }
        }

        node nextNode = current.next;
        prevNode.next = nextNode;

        System.out.println("\nSuccess!\n");
    }
}