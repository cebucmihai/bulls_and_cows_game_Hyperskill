package bullscows;
import java.util.*;
class invalidRange extends Exception{
    public invalidRange(){
        super("Error: it's not possible to generate a code with a length greater than the number of symbols.");
    }
}
class invalidLength extends Exception{
    public invalidLength(){
        super("Error : a code can't have a length of 0");
    }
}
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static int checkLength() throws invalidLength,NumberFormatException{
        String str=scanner.next();
        int length=Integer.parseInt(str);
        if(length==0) throw new invalidLength();
        return length;
    }
    public static int checkRange(int codeLength) throws invalidRange,NumberFormatException{
        String temp=scanner.next();
        int range= Integer.parseInt(temp);
        if(range>36) throw new invalidRange();
        if(codeLength>range) throw new invalidRange();
        return range;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turn=1;
        String code;
        GenerateCode generate= new GenerateCode();
        String temp=null;
        try {
            System.out.println("Input the length of the secret code:");
            int codeLength = checkLength();
            System.out.println("Input the number of possible symbols in the code:");
            int range=checkRange(codeLength);
            code=generate.randomCode(codeLength,range);
            System.out.println("Okay, let's start a game!");
            Grader grader = new Grader(code);
            String guess = scanner.next();
            boolean right_answer=false;
            while(!right_answer){
                System.out.println("Turn "+turn+":");
                turn++;
                right_answer = grader.check_code(guess,codeLength);
                if(right_answer){
                    break;
                }
                guess = scanner.next();
            }
        }catch(NumberFormatException e){
            System.out.println("Error: "+temp+" isn't a valid number.");
        }catch(invalidLength e){
            System.out.println(e.getMessage());
        }catch(invalidRange e){
            System.out.println(e.getMessage());
        }

    }
}
