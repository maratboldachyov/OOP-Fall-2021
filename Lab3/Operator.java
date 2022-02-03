import java.util.Scanner;

public abstract class Operator {
    static int initialValue;
    public Operator(){}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initialValue = scanner.nextInt();
        scanner.close();
        Add add = new Add();
        Subtract subtract = new Subtract();
        Multiply multiply = new Multiply();
        Divide divide = new Divide();
        Clear clear = new Clear();

        add.execute(4);
        System.out.println(initialValue);
        subtract.execute(4);
        System.out.println(initialValue);
        multiply.execute(4);
        System.out.println(initialValue);
        divide.execute(4);
        System.out.println(initialValue);
        clear.execute(4);
        System.out.println(initialValue);
    }

    public abstract void execute(int AnotherInitialValue);
}
