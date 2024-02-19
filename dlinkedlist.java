import java.util.Scanner;

class Dlinkedlist {
    public static void main(String[] args) {
        System.out.println("Doubly Linked List Implementation");
        
        Scanner sc = new Scanner(System.in);

        Dll doubly_list = new Dll();

        int ch = -1;

        while (ch != 0) {
            System.out.println("Please make a choice:");
            System.out.println("1. To Insert in the front of the list");
            System.out.println("2. To Insert in the middle of the list");
            System.out.println("3. To Insert at the end of thelist");
            System.out.println("4. To print the list");
            
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            if (ch == 0) {
                System.out.println("Exiting...");
            }
            else if (ch == 1) {
                System.out.print("Enter the data: ");
                int data = sc.nextInt();
                doubly_list.insertFront(data);
            }
            else if (ch == 2) {
                
            }
            else if (ch == 3) {

            }
            else if (ch == 4) {
                doubly_list.printList();
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
    }
}

