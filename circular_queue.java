import java.util.Scanner;

class c_queue {
    int front, rear, n;

    int[] q;

    c_queue(int size) {
        front = -1;
        rear = -1;
        q = new int[size];
        n = size;
    }

    void insert_queue(int item) {
        // If Queue is empty
        if (rear == -1) {
            front = 0;
            rear = 0;
            q[rear] = item;
            System.out.println("Inserted " + q[rear] + " at index " + rear);
        }
        else {
            rear = (rear + 1) % n;
            if (rear == front) {
                System.out.println("INSERT UNSUCCESSFUL: Circular queue is full");
                if (front == 0) {
                    rear = n - 1;
                }
                else {
                    rear = rear - 1;
                }
            }
            else{
                q[rear] = item;
                System.out.println("Inserted " + q[rear] + " at index " + rear);
            }
        }
    }

    void print_queue() {

        System.out.println("\nThe Queue is: ");
        // for (int i = 0; i < n; i++) {
        //     System.out.println(q[i]);
        // }

        if (front == -1 && rear == -1) {
            System.out.println("EMPTY");
        }
        else {
            int i = front;
            do {
                System.out.println(q[i]);
                i = (i + 1) % n;
            }
            while (i != (rear + 1) % n);
        }
    }

    void delete_queue() {
        if (rear == -1) {
            System.out.println("Queue is already empty!");
        }
        else {
            System.out.println("Deleting " + q[front] + " from index " + front);
            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % n;
            }
        }
    }
}



class circular_queue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the size of circular queue: ");
        int size = sc.nextInt();
        c_queue cq = new c_queue(size);
        
        int ch = -1;
      

        while (ch != 0) {
            System.out.println("\nCIRCULAR QUEUE: Make a choice");
            System.out.println("1. Insert into the queue");
            System.out.println("2. Print the circular queue");
            System.out.print("3. Delete from queue");
            System.out.print("\nMake your choice: ");
            ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("\nEnter an element to insert: ");
                int item = sc.nextInt();

                cq.insert_queue(item);
            }
            else if (ch == 2) {
                cq.print_queue();
            }
            else if (ch == 3) {
                cq.delete_queue();
            }
            else {
                System.out.println("\nInvalid input!");
            }
        }
    }    
}