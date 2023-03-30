package bullscows;

public class Grader {
    private String code;
    private static int round=1;
    public Grader (String code){
        this.code=code;
    }
    public static int[] make_array(int number,int length){
        int[] arr=new int[length];
        int i=0;
        int temp=number;
        while(number!=0){
            arr[i]=number%10;
            number=number/10;
            i++;
        }
        return arr;
    }
    public boolean check_code(String user_code,int length){
        //int[] temp=make_array(code,length),temp1=make_array(user_code,length);
        int bulls=0;
        int cows=0;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(code.charAt(i)==user_code.charAt(j)){
                    if(i==j){
                        bulls++;
                        continue;
                    }else{
                        cows++;
                        continue;
                    }
                }
            }
        }
        //System.out.println(user_code);
        if(bulls==0 && cows == 0){
            System.out.println("None. The secret code is " + code);
        }else {
            System.out.println(bulls+ " bulls and "+ cows + " cows. The secret code is " + code);
        }
        //if(bulls==0) {
            //System.out.println("Grade: " + cows + " cow(s). The secret code is "+code + ".");
        //}else{
            //System.out.println("Grade: " + bulls + " bull(s) and "+ cows + " cow(s). The secret code is "+ code +".");
        //}
        if(bulls==length){
            System.out.println("Congrats! The secret code is "+ code + ".");
            return true;
        }else
            return false;
    }
}
