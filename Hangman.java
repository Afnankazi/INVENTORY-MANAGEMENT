import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    static  Scanner scan = new Scanner(System.in);
    
    

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};
    public static void main(String[] args) {
        
        System.out.println("welcome to guess the word");
        System.out.println("you only get 6 tries so best of luck");
        int misses=0;
        int val=0;
        int j =0;
        int num = randomword();
        String word = words[num];
        //System.out.println(gallows[val]);
        System.out.println(word);
        char[] value =convert(word);
        char[] miss ={' ',' ',' ',' ',' ',' '};
        print(value,val,miss);
        char guess =scan.next().charAt(0);
        //com(word, guess, miss,j);
        //j++;
       
                //System.out.println(gallows[1]);
        while(true){
            //put this in if and else
            
           
           
           
            
           
            if (update(guess, value, word)) {
                val=0;
                System.out.println(gallows[val]);
                String newWord = value.toString();
                //print(checkguess(guess, value,value.toString()),val);
                print(checkguess(guess, value, word),val,com(word, guess, miss,j));
                j++;
                guess =scan.next().charAt(0);
                //com(word, guess, miss);
            }else{
                System.out.println();
                
                misses +=1;
                val +=1;
                System.out.println(gallows[val]);
                printmiss(checkguess(guess, value, word),com(word, guess, miss,j));
                guess =scan.next().charAt(0);
                //com(word, guess, miss);
            }
            //break;

            if(checkguess(guess, value, word)==word.toCharArray()){
                System.out.println("you won");
                System.exit(0);
            }
            if(misses == 6){
                System.out.println("RIP!");
                System.exit(0);
            }
        }    
       

     
    }
    public static char[] com(String word,char guess,char[] miss,int j){
       
        char[] words =word.toCharArray();
        
        for (int i = 0; i < words.length; i++) {
            if(words[i]== guess){
                i++;
                return miss;
            }
            else if(words[i] !=guess && words[i+1]!=guess && words[i+2] !=guess){
                
                miss[j]=guess;
                break;
           
               
            }
        
        }
        
       
        return miss;
    }



    public static void print(char[] word,int galows,char[] miss){
        
        System.out.println(gallows[galows]);
        System.out.print("words:\t");

        for(int i=0;i<word.length;i++){
            System.out.print(word[i]+"  ");

        }       
        System.out.print("\n\n");
        System.out.print("misses:\t");
        for (int i = 0; i < miss.length; i++) {
            System.out.print(miss[i]+" ");
        }
        System.out.println();
        System.out.print("guess:\t");
        
        //System.out.println();
        
    }
    public static void printmiss(char[] value,char[] miss){
        //char[] guessarray=new char[5];
        //guessarray[j]=guess;
        System.out.print("words:\t");
        for(int i=0;i<value.length;i++){
            System.out.print(value[i]+"  ");

        }
       

             
        System.out.print("\n\n");
        System.out.print("misses:\t");
        for (int i = 0; i <miss.length; i++) {
            System.out.print(miss[i]+" ");
            
        }
        System.out.println();
        System.out.print("guess:\t");

    }


    public static boolean update(char guess,char[] value,String word){
        char[] words = word.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if(words[i]==guess){
                 
                 return true;
            }
        }return false;    
    } 
  

    public static char[] checkguess(char guess,char[] value,String word){
        char[] words =word.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if(words[i]==guess){
                 value[i]=guess;
                 return value;
            }
            
        }
         return value;
    }




    public static int randomword() {
        double a = Math.random() * 65;
        int a1 = (int) a;
        return a1;
       

    }
    public static char[] convert(String word){
        char[] words =word.toCharArray();
       //System.out.print("words:\t");
        for (int i = 0; i < words.length; i++) {
            words[i]='_';
    
            
        }
        return words;
    }
}
