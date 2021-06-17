import java.util.Random;
import java.util.Scanner;

public class QuickS {
    public int partition(int arr[], int beg, int end){
        int piv = arr[end];
        int pindex = beg;

        for(int i = beg;i<end;i++){
            if(arr[i] <= piv){
                int temp = arr[i];
                arr[i] = arr[pindex];
                arr[pindex] = temp;

                pindex++;
            }
        }
        int temp = arr[pindex];
        arr[pindex] = arr[end];
        arr[end] = temp;
        return pindex;
    }

    public void sort(int arr[], int beg,int end){
        if(beg <end){
            int pindex = partition(arr,beg,end);
            sort(arr,beg,pindex-1);
            sort(arr,pindex+1,end);
        }
    }

    static void display(int arr[]){
        int len = arr.length;
        System.out.println();
        System.out.println("The sorted array is:");
        for(int i = 0;i< len;i++){
            System.out.println(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        int arr[],n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        n = sc.nextInt();
        arr = new int[n];

        Random ran = new Random();
        for(int i = 0;i<n;i++){
            arr[i] = ran.nextInt(5000);
        }
        System.out.println("The unsorted array is:");
        for(int i = 0;i<n;i++){
            System.out.println(arr[i] + " ");
        }

        QuickS ob = new QuickS();
        long start = System.currentTimeMillis();
        ob.sort(arr, 0, n-1);
        long fin = System.currentTimeMillis();

        display(arr);
        System.out.print("Time taken:");
        System.out.println(fin-start +"ms");
    }
}
