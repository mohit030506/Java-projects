import java.util.Scanner;

public class calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num1;
        int num2;
        int add,sub,mul,div;

        System.out.print("Enter the first number:");
        num1 = scanner.nextInt();

        System.out.print("Enter the second number:");
        num2 = scanner.nextInt();

        add = num1 + num2;

        System.out.println("Sum of two numbers are :" +add);

        sub = num1 - num2;

        System.out.println("Substraction of two numbers are :" +sub);

        mul = num1*num2;

        System.out.println("Multiplication of two numbers are :" +mul);

        div = num1/num2;

        System.out.println("Divsion of first number by second number is :"  +div);
    }
}