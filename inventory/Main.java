
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



class Main {
    public static final int TOTAL_EMPLOY=4;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Path[] paths = new Path[] {Paths.get("data.txt")};
        System.out.println("enter yor name ");
        String username = scan.nextLine();
        System.out.println("enter the password");
        String password = scan.nextLine();
        try {
            loadacc(paths,username,password);
  
        } catch (Exception e) {
            System.out.println(e);
        }
        scan.close();
    }
    public static void loadacc(Path[] paths,String username,String pass) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream("data.txt");  
        Scanner scan = new Scanner(fis);

    while(scan.hasNextLine()){
        
        for (int i = 0; i < TOTAL_EMPLOY; i++) {
            String line = scan.nextLine();
            String[] word = line.split(" ");
            if(word[0].equals(username)&&word[1].equals(pass)){
                if(word[2].equals("OWNER")){
                    owner(word[0]);
                    break;

                }else if(word[2].equals("EMPLOY")){
                    employe(word[0]);
                    break;

                
                } else{                                                                                                                                                                       
                    System.out.println("error");
                }     
                

            }else if (i==TOTAL_EMPLOY-1){
                Path[] path = new Path[] {Paths.get("data.txt")};
                Scanner scan2 = new Scanner(System.in);
                System.out.println("\n");
                System.out.println("invalid user name or pass");
                System.out.println("enter username");
                String u = scan2.nextLine();
                System.out.println("enter password");
                String p = scan2.nextLine();
                loadacc(path, u, p);
                scan2.close();
            } 
            else{
                continue;
            }

        }
        break;
    }
   
    scan.close();
         
        
     
           
     
      }
      public static void owner(String words){
          System.out.println("wlecome "+words);

        //logic
      }
      public static void employe(String words){
          System.out.println("welcome "+words);
          //logic
      }
   


}
