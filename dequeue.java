import java.util.Scanner;

class d_queue {
    int front, rear, n;

    int[] q;

    d_queue(int size) {
        front = -1;
        rear = -1;
        q = new int[size];
        n = size;
    }

    void insert_front(int item) {
        if (rear == -1) {
            front = 0;
            rear = 0;
            q[front] = item;
            System.out.println("Inserted " + q[front] + " at index " + front);
        }
        else {
            if (front == 0 && rear == n - 1){
                System.out.println("UNSUCCESSUFUL: Queue is full!");
            }
            else {
                for(int i = rear; i >= 0; i--){
                    q[i+1] = q[i];
                }
                q[0] = item;

                System.out.println("Inserted " + q[front] + " at index " + front); 

                rear = rear + 1;
            }
        }
    }
    
    void delete_front() {
        if (rear == -1) {
            System.out.println("Queue is already empty!");
        }
        else {
            if (front == rear){
                // BOOKMARK
                System.out.println("Deleting "  + q[front] + " from index " + front);

                front = -1;
                rear = -1;
            }
            else {
                System.out.println("Deleting "  + q[front] + " from index " + front);

                for (int i = 0; i <= rear - 1; i++) {
                    q[i] = q[i+1];        
                }
                
                rear = rear - 1;
            }     
        }
    }

    void insert_rear(int item) {
        if (rear == -1) {
            front = 0;
            rear = 0;
            q[rear] = item;
        }
        else {
            if (front == 0 && rear == n-1) {
                System.out.println("UNSUCCESSFUL: Queue is already full.");
            }
            else {
                rear = rear + 1;
                q[rear] = item;
                System.out.println("Inserted " + q[rear] + " to index " + rear);
            }
        }
    }

    void delete_rear() {
        if (rear == -1 && front == -1) {
            System.out.println("Queue is already empty!");
        }
        else {
            System.out.println("Deleting " +  q[rear] + " from index " + rear);

            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                rear = rear - 1;
            }
        }
    }

    void print_dequeue() {
        System.out.println("\nThe Queue is: ");     
        if (front == -1 && rear == -1) {
            System.out.println("EMPTY");
        }
        else {
            for (int i = front; i <= rear; i++) {
                System.out.println(q[i]);
            }
        }
    }
}



class dequeue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the size of circular queue: ");
        int size = sc.nextInt();
        d_queue dq = new d_queue(size);
        
        int ch = -1;
      

        while (ch != 0) {
            System.out.println("\nCIRCULAR QUEUE: Make a choice");
            System.out.println("1. Insert into the front of the queue");
            System.out.println("2. Delete from the front of the queue");
            System.out.println("3. Insert into the rear of the queue");
            System.out.println("4. Delete from the rear of the queue");
            System.out.println("5. Print the DEqueue");
            System.out.println("0. To exit");
            System.out.print("Make your choice: ");
            ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("\nEnter an element to insert at the front: ");
                int item = sc.nextInt();

                dq.insert_front(item);
            }
            else if (ch == 2) {
                dq.delete_front();
            }
            else if (ch == 3) {
                System.out.print("\nEnter an element to insert at the rear: ");
                int item = sc.nextInt();
                dq.insert_rear(item);
            }
            else if (ch == 4) {
                dq.delete_rear();
            }
            else if (ch == 5) {
                dq.print_dequeue();
            }
            else {
                System.out.println("\nInvalid input!");
            }
        }
    }    
}