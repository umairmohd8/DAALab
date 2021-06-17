import java.util.ArrayList;
import java.util.Scanner;

class Staff{
    private String staffID;
    private String name;
    private String phone;
    private String salary;

    public static final Scanner in = new Scanner(System.in);
    void readInfo(){
        System.out.println("\nEnter the StaffID,Name,Phone,salary");
        this.staffID = in.nextLine();
        this.name  = in.nextLine();
        this.phone = in.nextLine();
        this.salary = in.nextLine();
    }

    void display(){
        System.out.println("\nThe details of the staff are:");
        System.out.printf("StaffID: %s\nName: %s\nPhone: %s\nSalary: %s\n",
                         staffID,name,phone,salary);
    }
}

class Techinical extends Staff{
    public StringBuilder skills  = new StringBuilder("");
    public Techinical(){
        readInfo();
    }
    void readInfo(){
        super.readInfo();
        System.out.println("\nEnter the technical skills:");
        while(Staff.in.hasNextLine()){
            String str = Staff.in.nextLine();
            if(str == "") break;
            skills.append(str + "\n");
        }
        // String skills = Staff.in.nextLine();
    }

    void display(){
        System.out.println("Displaying Technical staff details:");
        super.display();
        System.out.println("\nTechnical skills are:\n" + skills);
    }
}

class Teaching extends Staff{
    public String domain;
    public String publications;
    public Teaching(){
        readInfo();
    }

    void readInfo(){
        super.readInfo();
        System.out.println("\nEnter the Domain and Publications");
        domain = Staff.in.nextLine();
        publications= Staff.in.nextLine();
    }
    void display(){
        System.out.println("Displaying Teaching staff details:");
        super.display();
        System.out.printf("\nDomain: %s\nPublications: %s",domain,publications); 
    }
}

class Contract extends Staff{
    public String contract;
    public Contract(){
        readInfo();
    }
    void readInfo(){
        super.readInfo();;
        System.out.println("\nEnter the contract period:");
        contract = Staff.in.nextLine();
    }

    void display(){
        System.out.println("Displaying Contract staff details:");
        super.display();
        System.out.printf("\nContract Period: %s\n", contract);
    }
}
public class Lab2a {
    public static void main(String[] args) {
        int i = 1, head = 0, j;
        ArrayList<Teaching> teach = new ArrayList<Teaching>();
        ArrayList<Techinical> tech = new ArrayList<Techinical>();
        ArrayList<Contract> con = new ArrayList<Contract>();
        while(i != 0){
            System.out.println("\nEnter the type of staff:\n1 for Teaching");
            System.out.println("2 for Technical\n3 for Contract\n4 to Exit.");
            j = Staff.in.nextInt();
            if(j ==4) break;
            if(j > 4){
                System.out.println("Enter the correct choice");
                continue;
            }
            System.out.println("\nEnter:\n1 to Read info\n2 to display info");
            System.out.println("3 to add info\n");
            i = Staff.in.nextInt();

            switch(i){
                case 1: System.out.println("Enter the number of staff:");
                        int n = Staff.in.nextInt();
                        Staff.in.nextLine();
                        for(;head < n; head++){
                            if(j == 1) teach.add(new Teaching());
                            if(j == 2) tech.add(new Techinical());
                            if(j == 3) con.add(new Contract());
                        }
                        head = 0;
                        break;
                case 2: if(j ==1){
                            if(teach.size() == 0) System.out.println("No details");
                            for(Teaching stf: teach ){
                                stf.display();
                            }
                        }
                        if(j ==2){
                            if(tech.size() == 0) System.out.println("No details");
                            for(Techinical stf: tech ){
                                stf.display();
                            }
                        }
                        if(j ==3){
                            if(con.size() == 0) System.out.println("No details");
                            for(Contract stf: con ){
                                stf.display();
                            }
                        }
                        break;
                case 3: if(j == 1) teach.add(new Teaching());
                        if(j == 2) tech.add(new Techinical());
                        if(j == 3) con.add(new Contract());
                        break;
                default: System.out.println("Enter the correct choice");

                
            }
            
        }
    }
}
