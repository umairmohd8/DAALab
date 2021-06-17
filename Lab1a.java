import java.util.Scanner;

class Student{
    String usn,name,programme,phone;
    // constructor    
    public Student(String usn,String name,String programme, String phone){
        this.usn =usn;
        this.name =name;
        this.programme =programme;
        this.phone =phone;
        }
    void printInfo(){
        System.out.println("The details of the student are:");
        System.out.printf("USN:%s\nName:%s\nProgamme:%s\nPhone:%s",
                            usn,name,programme,phone);
    }
}

public class Lab1a {
    public static void main(String[] args) {
        int n;
        String usn,name,programme,phone;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of variables:");
        n = Integer.parseInt(sc.nextLine());
        // array of objects
        Student[] stud = new Student[n+1];
        for(int i = 1; i<=n; i++){
            // input details
            System.out.println("Enter the usn,name,programme,phone of the student " + i);
            usn = sc.nextLine();
            name =sc.nextLine();
            programme =sc.nextLine();
            phone = sc.nextLine();
            // object creation 
            stud[i] = new Student(usn, name, programme, phone);
        }
        // printing student info
        while(true){
            System.out.println("\nEnter the student number to print info or 0 to exit: ");
            int i = sc.nextInt();
            if(i == 0) break;  
            stud[i].printInfo();
        }  
    }

}
