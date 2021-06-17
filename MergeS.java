import java.util.Random;
import java.util.Scanner;

class MergeS
{
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
 
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            merge(arr, l, m, r);
        }
    }
 
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
        Random random = new Random();
        int arr[],n;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        n = in.nextInt();
        arr = new int[n];

      
      
        System.out.println("Reading the elements elements:");
        for(int i = 0; i<n;i++){
           arr[i] = random.nextInt(5000);
        }
        
        MergeS ob = new MergeS();                              
        long start = System.currentTimeMillis();
        ob.sort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
 
        System.out.println("\nSorted array");
        printArray(arr);
        System.out.print("Time taken:");
        System.out.println(end-start +"ms");
    }
}