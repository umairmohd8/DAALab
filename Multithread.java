import java.util.Random;
//thread one
class Square extends Thread{
    public void run(int i){
        try {
            int res = i*i;
            System.out.println("The square of "+ i + " is: "+res);
        } catch (java.lang.Exception e) {
            //TODO: handle exception
            System.out.println("Exception found in square thread:"+ e);
        }
    }
    
}
//thread two 
class Cube extends Thread{
    public void run(int i){
        try {
            int res = i*i*i;
            System.out.println("The cube of "+ i + " is: "+ res);
        } catch (java.lang.Exception e) {
            //TODO: handle exception
            System.out.println("Exception found in cube thread: "+ e);
        }
    }
}

public class Multithread {
    public static void main(String[] args) {
        Square sq = new Square();
        Cube cb = new Cube();
        Random rand = new Random();
        
        int n = 10;

        while(n>0){
            int i = rand.nextInt(1000);
            sq.run(i);
            cb.run(i);
            // use try and catch 
            try {
                Thread.sleep(100);
            } catch (java.lang.Exception e) {
                //TODO: handle exception
                System.out.println("Execption found: "+ e);
            }
            
            n--;
        }
    }
}
