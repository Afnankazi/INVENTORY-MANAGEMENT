import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Authentication {
    public static final int TOTAL_USERS = 2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Path[] paths = new Path[]{Paths.get("authentication.txt")};

        System.out.print("Enter yor name:- ");
        String username = scan.nextLine();

        System.out.print("Enter your password:- ");
        String password = scan.nextLine();

        try {
            loadacc(paths, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }

        scan.close();
    }

    public static void loadacc(Path[] paths, String username, String pass) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("authentication.txt");
        Scanner scan = new Scanner(fis);

        while (scan.hasNextLine()) {
            for (int i = 0; i < TOTAL_USERS; i++) {
                String line = scan.nextLine();
                String[] word = line.split(" ");
                if (word[0].equals(username) && word[1].equals(pass)) {
                    if (word[2].equals("OWNER")) {
                        owner(word[0]);
                        break;
                    } else if (word[2].equals("EMPLOYEE")) {
                        employe(word[0]);
                        break;
                    } else {
                        System.out.println("error");
                    }


                } else if (i == TOTAL_USERS - 1) {
                    Path[] path = new Path[]{Paths.get("authentication.txt")};
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("\n");
                    System.out.println("invalid user name or pass");
                    System.out.println("enter username");
                    String u = scan2.nextLine();
                    System.out.println("enter password");
                    String p = scan2.nextLine();
                    loadacc(path, u, p);
                    scan2.close();
                } else {
                    continue;
                }

            }
            break;
        }

        scan.close();


    }

    public static void owner(String words) {
        System.out.format("\n\t\t<------------------- Welcome %s ----------------------->", words);
        Inventory innventory_object = new Inventory();
        innventory_object.main();
    }

    public static void employe(String words) {
        System.out.println("welcome " + words);
        //logic
    }


}