import java.util.Scanner;
// 0/1 knapsack using greeedy <not optimal>
public class knapsack {
    int size,cap,sum = 0;
    int arr[][];

    void read(){
        Scanner input = new Scanner(System.in);
        // no of elements in the problem 
        System.out.println("Enter the number of elements:");
        size = input.nextInt();
        // initializing the array
        arr = new int[2][size];

        //reading the values of the element
        System.out.println("Enter the Values of the elements:");
        for(int i = 0;i<size;i++){
            arr[0][i] = input.nextInt();
        }

        //reading the weights of the elements
        System.out.println("Enter the Weights of the elements:");
        for(int i = 0; i< size; i++){
            arr[1][i] = input.nextInt();
        }

        System.out.println("Enter the capacity:");
        cap = input.nextInt();
    }

    void run(){
        int j=0,m = cap;
        float ratio;
        while(m > 0){
            float max = 0;  // resets the max ratio 
            for(int i = 0;i < size;i++){
                //ratio of value/weight
                ratio = ((float)arr[0][i])/((float)arr[1][i]);
                //System.out.println("the current ratio is " + ratio);
                if(ratio > max){
                    max = ratio;
                    j = i;
                }
            }
            // checks if the weight of the element is less than the capacity
            if(arr[1][j] < m){
                m -= arr[1][j]; //updates the capacity
                sum += arr[0][j];  //increments the sum 
                arr[0][j] = 0;
            }
            else{
                return;
            }
        }
    }

    void display(){
        System.out.println("The maximum value of elements that can be put in is:");
        System.out.println(sum);
        System.out.println("The capacity of elements is");
        System.out.println(cap);
    }
    public static void main(String[] args) {
        knapsack obj = new knapsack();
        obj.read();
        obj.run();
        obj.display();
    }
}
