import java.io.*;
import java.util.*;

public class Game {
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Enter Game: ");
            System.out.println("2. Exit: ");
            int choice = new Scanner(System.in).nextInt();
            if (choice == 2) {
                break;
            }
            System.out.println("1. Beginner");
            System.out.println("2. Medium");
            System.out.println("2. Intermediate");
            System.out.println("2. Hard");
            int level = new Scanner(System.in).nextInt();
            File inputFile = new File("Input.txt");
            File outputFile = new File("Output.txt");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
                String line = "User Name " + "\tLevel" + "\tScore" + "\tTime"+"\n";
                writer.write(line);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            List<String> expressions = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                String expression;
                while ((expression = reader.readLine()) != null) {
                    String[] temp = (expression.split(","));
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = temp[i].trim();
                    }
                    for (int i = 0; i < temp.length; i++) {
                        expressions.add(temp[i]);
                    }
                }
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            /* for (int i = 0; i < expressions.size(); i++) {
                System.out.println(expressions.get(i));
            }*/
            if (level == 1) {
                int lvl_max = 25;
                System.out.println("Enter Your Name: ");
                String user_name = new Scanner(System.in).nextLine();
                int score = 0;
                for (int i = 1; i <= lvl_max; i++) {
                    System.out.println(expressions.get(i));
                    int result = result(expressions.get(i));
                    int user_result = new Scanner(System.in).nextInt();
                    if (result == user_result) score++;
                }
                if (score == lvl_max) System.out.println("Congratulation!!!");
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
                    String line = user_name + "\tBeginner" + "\t" + score + "\n";
                    writer.write(line);
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (level == 2) {
                int lvl_max = 50;
                System.out.println("Enter Your Name: ");
                String user_name = new Scanner(System.in).nextLine();
                int score = 0;
                for (int i = 1; i <= lvl_max; i++) {
                    System.out.println(expressions.get(i));
                    int result = result(expressions.get(i));
                    int user_result = new Scanner(System.in).nextInt();
                    if (result == user_result) score++;
                }
                if (score == lvl_max) System.out.println("Congratulation!!!");
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
                    String line = user_name + "\tBeginner" + "\t" + score + "\n";
                    writer.write(line);
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (level == 3) {
                int lvl_max = 75;
                System.out.println("Enter Your Name: ");
                String user_name = new Scanner(System.in).nextLine();
                int score = 0;
                for (int i = 1; i <= lvl_max; i++) {
                    System.out.println(expressions.get(i));
                    int result = result(expressions.get(i));
                    int user_result = new Scanner(System.in).nextInt();
                    if (result == user_result) score++;
                }
                if (score == lvl_max) System.out.println("Congratulation!!!");
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
                    String line = user_name + "\tBeginner" + "\t" + score + "\n";
                    writer.write(line);
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (level == 4) {
                int lvl_max = 100;
                System.out.println("Enter Your Name: ");
                String user_name = new Scanner(System.in).nextLine();
                int score = 0;
                for (int i = 1; i <= lvl_max; i++) {
                    System.out.println(expressions.get(i));
                    int result = result(expressions.get(i));
                    int user_result = new Scanner(System.in).nextInt();
                    if (result == user_result) score++;
                }
                if (score == lvl_max) System.out.println("Congratulation!!!");
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));
                    String line = user_name + "\tBeginner" + "\t" + score + "\n";
                    writer.write(line);
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static int result(String s) {
        int result = 0, index = 0;
        char c = '0';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                c = s.charAt(i);
                index = i;
                break;
            }
        }
        int number1 = Integer.parseInt(s.substring(0, index));
        int number2 = Integer.parseInt(s.substring(index + 1));
        switch (c) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number1 != 0)
                    result = number1 / number2;
                break;
        }
        return result;
    }
}