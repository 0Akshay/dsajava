import java.util.Scanner;

class q_arr{
    int front, rear, n;
    int q[];
    q_arr(int size){
        front = -1;
        rear = -1;
         q = new int[size];
         n = size;
    }

    void insert_queue(int item){
        if(rear == -1){
            front = 0;
            rear = 0;
            q[rear] = item;
        }    
        else{
            if(rear == n-1){
                System.out.println("Queue is full");
            }
            else{
                rear = rear + 1;
                q[rear] = item;
                System.out.println("\nInsert Successful");
            }
        }
    }

    void queue_display(){
        for(int i = front; i<= rear; i++){
            System.out.println(q[i]);
        }
    }

    public static void main(String[] args) {
        System.out.print("hello");
    }
}

class queue_array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the size of queue array: ");
        int size = sc.nextInt();
        q_arr qa = new q_arr(size);

        int ch = -1;

        while(ch != 0) {

            System.out.println("\nOptions: ");
            System.out.println("1. To Insert in the queue");
            System.out.println("2. To Delete from the queue");
            System.out.println("3. Print the queue");
            System.out.println("0. To exit");
            System.out.print("\nPlease select an option: ");

            ch = sc.nextInt();

            if (ch == 1){
                System.out.print("\nEnter an integer to insert: ");
                int item = sc.nextInt();
                qa.insert_queue(item);
            }

            else if (ch == 2){
                qa.front = qa.front + 1;
            }
            else if (ch == 3){
                qa.queue_display();
            }
            else if (ch == 0){
            }
            else {
                System.out.print("\nInvalid Input");
            }
        }
    }
}
