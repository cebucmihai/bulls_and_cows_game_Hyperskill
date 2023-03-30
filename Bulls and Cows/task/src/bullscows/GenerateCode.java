package bullscows;
import java.util.Random;
public class GenerateCode {
    public static String randomCode(int size,int range){
        if(size > 36){
            System.out.printf("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return null ;
        }
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random rand=new Random();
        char code=alphabet.charAt(rand.nextInt(range));
        int sw=0;
        String str=""+code;
        int aux=size-1;
        boolean good_code=false;
            while(aux>0){
                aux--;
                sw=0;
                code=alphabet.charAt(rand.nextInt(range));;
                for(int i=0;i<str.length();i++){
                    if(code==str.charAt(i)) {
                        aux++;
                        sw=1;
                        break;
                    }
                }
                if(sw==0){
                    str=str+code;
                }

            }
            String secret="";
            for(int i=0;i<size;i++){
                secret+="*";
            }
        System.out.println("The secret is prepared: " + secret + "("+  (range<10?"0-"+alphabet.charAt(range-1) + ").":"(0-9,a-"+alphabet.charAt(range-1)+")."));
        return str;
    }
}
