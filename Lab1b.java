import java.util.Scanner;

class Stack {
    int[] stack;
    int top; 
    // constructor defining stack size and top 
    public Stack(int size){
        stack = new int[size];
        top = -1;
    }
    
    Scanner sc = new Scanner(System.in);

    void push(int ele) {
        if(top >= stack.length-1){
            System.out.println("--Stack over flow.--");
            return;
        }
        stack[++top] = ele;
    }

    void pop() {
        if(top == -1){
            System.out.println("--Stack underflow.--");
            return;
        }
        System.out.printf("The popped element is: %d\n", stack[top--]);
    }

    void display() {
        if(top == -1){
            System.out.println("\nEmpty stack!!");
        }
        for (int j = 0; j <= top; j++) {
            System.out.printf("%d |", stack[j]);
        }
    }

}

public class Lab1b {
    public static void main(String[] args) {
        // taking the size of the stack
        System.out.println("Enter the size of stack:");
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        // creating a new stack object
        Stack st1= new Stack(size);

        int i = 1;
        while(i != 0){
            System.out.println("\nEnter the action\n1:Push\n2.Pop\n3.Display\n4.Exit");
            int k = in.nextInt();
            switch (k) {
                case 1: System.out.println("Enter the element to push:");
                        st1.push(in.nextInt());
                    break;
                case 2: st1.pop();;
                     break;
                case 3: st1.display();
                     break;
                case 4: i =0;
                     break;
            
                default: System.out.println("Enter the correct choice.");
                    break;
            }
        }
    }
}
