import java.util.Scanner;

public class Dlinkedlist {
    public static void main(String[] args) {
        System.out.println("Doubly Linked List Implementation");
        
        Scanner sc = new Scanner(System.in);

        Dll doubly_list = new Dll();

        int ch = -1;

        while (ch != 0) {
            System.out.println("\nPlease make a choice:");
            System.out.println("1. To Insert in the front of the list");
            System.out.println("2. To Insert in the middle");
            System.out.println("3. To Insert at the end of thelist");
            System.out.println("4. To print the list");
            System.out.println("5. To delete from front of the list");
            System.out.println("6. To delete from the rear");
            System.out.println("7. To delete from the middle");
            System.out.print("Enter your choice: ");
            
            ch = sc.nextInt();
            
            System.out.println("");

            if (ch == 0) {
                System.out.println("Exiting...");
            }
            else if (ch == 1) {
                System.out.print("Enter the data: ");
                int data = sc.nextInt();
                doubly_list.insertFront(data);
            }
            else if (ch == 2) {
                System.out.print("\nEnter the position you would like to insert at: ");
            int pos = sc.nextInt();
            
            System.out.print("\nEnter the data: ");
            
            int data = sc.nextInt();
            
            doubly_list.insertMiddle(pos, data);
            }
            else if (ch == 3) {
                System.out.print("\nEnter the data: ");
                int data = sc.nextInt();
            doubly_list.insertRear(data);

            }
            else if (ch == 4) {
                doubly_list.printList();
            }
            else if (ch == 5) {
                    doubly_list.deleteFront();
            }
            else if (ch == 6) {
                    doubly_list.deleteRear();
                }
            else if (ch == 7) {
System.out.print("\nEnter the position you would like to delete from: ");
int pos = sc.nextInt();   doubly_list.deleteMiddle(pos);
                    }
            else {
                System.out.println("Invalid Input!");
            }
        }
    }
}


class Dll {
    static class Node {
        int data;
        Node prev;
        Node next;
    }

    Node startPtr = null;


    void printList() {
        Node q = startPtr;
        if (q == null) {
            System.out.println("List is empty!");
        }
        else {
            while (q != null) {
                System.out.println(q.data);
                q = q.next;
            }
        }
    }


    void insertFront(int data) {
        if (startPtr == null) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = null;
            newNode.prev = null;

            startPtr = newNode;
        }
        else {
            Node newNode = new Node();
            newNode.data = data;
            newNode.prev = null;

            newNode.next = startPtr;
            startPtr.prev = newNode;
            startPtr = newNode;
        }
    }


    void insertRear(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        
        Node q = startPtr;
        while (q.next != null) {
            q = q.next;
        }
        
        newNode.prev = q;
        q.next = newNode;
    }
    
    
    void insertMiddle(int pos, int data) {
        Node q = startPtr;
        if (pos == 0) {
            insertFront(data);
            return;
        }
        
        /*int i = 0;
        while (i < pos - 1) {
            q = q.next;
        }
        */
        
        int i = 0;
        while (i < pos) {
            q = q.next;
            if (q == null) {
                System.out.println("Out of bounds");
                return;
            }
            i++;
        }
        
        if (q.next == null) {
            insertRear(data);
        }
        
        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = q.prev;
        newNode.next = q;
        
        q.prev.next = newNode;
        q.prev = newNode;
    }
    
    
    void deleteFront() {
        startPtr = startPtr.next;
        int data = startPtr.prev.data;
        startPtr.prev = null;
        System.out.println(data);
    }
    
    
    void deleteRear() {
        Node q = startPtr;
        while(q.next != null) {
            q = q.next;
        }
        if (q.prev == null) {
            startPtr = null;
        }
        else {
            q.prev.next = null;
        }
    }
    
    void deleteMiddle(int pos) {
        Node q = startPtr;
        
        int i = 0;
        while (i < pos) {
            q = q.next;
            
            if (q == null) {
                System.out.println("Out of bounds!");
            }
            i++;
        }
        
        if (q.prev == null && q.next == null) {
            startPtr = null;
        }
        else if (q.prev == null) {
            startPtr = startPtr.next;
            startPtr.prev = null;
        }
        else if (q.next == null) {
            q.prev.next = null;
        }
        else {
            q.next.prev = q.prev;
            q.prev.next = q.next;
        }
    }
}
