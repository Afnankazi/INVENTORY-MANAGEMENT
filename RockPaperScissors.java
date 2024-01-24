import java.util.Scanner;



public class RockPaperScissors {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.");
        System.out.println("Are you ready? Write 'yes' if you are.");
        String A =scan.next();
    //Task 1: See if the user wants to play. 
        if (A.equals("yes")){
            System.out.println("Great!");
            System.out.println(" rock - paper - scissors, shoot!");
            String R =scan.next();
            if (error(R)){System.out.println("invalid option");
            System.exit(0);}else{}
            String c =coumputerchoice();
            String B=result(R, c);
            printResult(R, c, B);
        }
        else{System.out.println("ok play next time");}
              

        scan.close();
    }

    public static String coumputerchoice(){
        double choice = (Math.random()*3);      
        int choice1 = (int)choice;
        switch (choice1) {
            case 0:return ("rock");
            case 1:return("paper");
            case 2:return("scissors");
            default:return ("error");
        }        
    }
    public static boolean error(String result){
        boolean N =(!result.equals("rock") && (!result.equals("scissors")) && (!result.equals("paper")) );
        return N;

    }

    public static String result(String yourChoice, String computerChoice) {
        String result1;
        if(yourChoice.equals("rock") && computerChoice.equals("scissors")){return result1 = "you won";
        
        }
        else if(yourChoice.equals("paper") && computerChoice.equals("rock")) {return result1  = "you won";}
        else if(yourChoice.equals("scissors") && computerChoice.equals("paper")) {return result1 = "you won";}
        else if(yourChoice.equals(computerChoice)){return result1 ="you tied";}
        else  {return result1 = "you lost";}
       
        }
    public static void printResult(String yourChoice,String computerchoice,String Result){
        System.out.println("\nYou chose:\n\t " +yourChoice);
        System.out.println("\nThe computer chose:\n\t "+ computerchoice);
        System.out.println("\nresult:\n\t "+Result );

    }    
    
}
