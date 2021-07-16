import java.util.Scanner;
import java.util.StringTokenizer;

public class StringToken {
    String word;
    String name, dd, mm, yyyy;

    void format(String d, String m, String y) {

        if (d.length() != 2 || m.length() != 2 || y.length() != 4) {
            System.err.println("format error");
            System.exit(0);
        }
    }

    void stringsplit(String word) {
        StringTokenizer str = new StringTokenizer(this.word, "/");
        dd = str.nextToken();
        mm = str.nextToken();
        yyyy = str.nextToken();
        format(dd, mm, yyyy);
    }

    void read() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name and dob in the format <dd/mm/yyyy>:");
        name = in.nextLine();
        word = in.nextLine();

        stringsplit(word);
    }

    void display() {
        System.out.println("The customer data is:");
        System.out.printf("%s, %s, %s, %s", name, dd, mm, yyyy);
    }

    public static void main(String[] args) {
        StringToken st = new StringToken();
        st.read();
        st.display();
    }
}
