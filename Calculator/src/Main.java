import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String getString(){
        String result;
        do {
            result = scanner.nextLine();
        } while (result.isEmpty());
        return result;
    }
    static Complex inputValue(String prompt){
        System.out.print(prompt + " (separate the real and imaginary parts with a space):");
        String[] values = getString().split(" ");
        return (values.length > 1) ?
                new Complex(Double.valueOf(values[0]), Double.valueOf(values[1])):
                new Complex(Double.valueOf(values[0]));
    }
    static List<String> logger = new ArrayList<String>();

    public static void main(String[] args) {

        Complex a, b, c;
        while (true){
            System.out.println("Enter the command:\n" +
                    "\t+. Add two numbers\n" +
                    "\t-. Subract the second number from the first\n" +
                    "\t*. Multiply two numbers\n" +
                    "\t/. Divide the first number by the second\n" +
                    "\ts. Show logs\n" +
                    "\tq. Quit\n");
            try {
                String cmd = getString();
                if (cmd.equals("q") || cmd.equals("Q")) return;
                if (cmd.equals("s") || cmd.equals("S")) {
                    System.out.println("All operations:");
                    for (String s: logger) {
                        System.out.println(s);
                    }
                    System.out.println("------------------------------");
                    continue;
                }

                a = inputValue("Input the first number");
                b = inputValue("Input the second number");
                switch (cmd) {
                    case "+":
                        c = a.plus(b);
                        break;
                    case "-" :
                        c = a.minus(b);
                        break;
                    case "*":
                        c = a.mul(b);
                        break;
                    case "/":
                        c = a.div(b);
                        break;
                    case default:
                        throw new IncorrectCommand(cmd);
                }
                String result = String.format("%s %s %s = %s", a, cmd, b, c);
                logger.add(result);
                System.out.println(result);
            }
            catch (IncorrectCommand ex) {
                System.out.println(ex.getMessage());
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}