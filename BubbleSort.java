import java.util.Scanner;

class BubbleSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] arr;

        System.out.print("\nWould you like to use the default array (Enter 1 for yes and 0 for no): ");

        int ch = sc.nextInt();

        if (ch == 1) {
            int[] defaultArr = new int[]{22, 46, 78, 638, 388, 4, 5258, 741, 54, 14, 7, 62, 885, 9};

            arr = defaultArr;
        }
        else if(ch == 0) {
            System.out.print("\nEnter the size of array: ");
            
            int size = sc.nextInt();

            int[] arr2 = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.print("\nEnter element at " + i + ": ");
                int value = sc.nextInt();
                arr2[i] = value;
            }
            
            arr = arr2;
        }
        System.out.print("\nArray selected");


    }
}