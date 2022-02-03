public class Divide extends Operator{
    public void execute(int anothervalue){
        if(anothervalue == 0){
            System.out.println("It is not allowed to divide by 0!");
        }
        else{
            initialValue/=anothervalue;
        }
    }
}
