import java.util.Scanner;

public class Exception{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b= in.nextInt();

        try{
            int c = a/b;
            System.out.println(c);
        }
        catch(java.lang.Exception e){
            System.out.println("The value of b is zero, " + e);
        }
    }
}
