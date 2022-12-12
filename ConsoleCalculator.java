import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConsoleCalculator {
    private static String[] rome =  {"X","I","II","III","IV","V","VI","VII","VIII","IX"};
    private static String [] arab = {"10","1","2","3","4","5","6","7","8","9"};
    private static String [] operator = {"+","-","/","*"};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        System.out.println(calc(input));
    }
    public static String calc(String input){
        String[] words = input.split("\\s");
        if (words.length != 3) {
            throw new RuntimeException("Строка не удовлетворяет заданию");

        }else if ( Arrays.asList(arab).contains(words[0]) && Arrays.asList(arab).contains(words[2]) && Arrays.asList(operator).contains(words[1])){
            String s = Integer.toString(calc(Integer.parseInt(words[0]), Integer.parseInt(words[2]), words[1]));
            return s;
        } else if (Arrays.asList(rome).contains(words[0]) && Arrays.asList(rome).contains(words[2]) && Arrays.asList(operator).contains(words[1])) {
            RomanToDecimal romanToDec = new RomanToDecimal();
            int one = romanToDec.romanToDecimal(words[0]);
            int two = romanToDec.romanToDecimal(words[2]);
            IntegerToRoman integerToRoman = new IntegerToRoman();
            String sum = Integer.toString(calc(one, two, words[1]));
            if (Integer.parseInt(sum) > 0) {
                String sumRoman = integerToRoman.intToRoman(Integer.parseInt(sum));
                return sumRoman;
            } else {
                throw new RuntimeException("В римской системе нет отрицательных чисел");
            }
        }  else {
            throw new RuntimeException("Используются одновременно разные системы счисления");
        }
//        return input;
    }
    public static int calc(int num1, int num2, String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "*":
                result = num1*num2;
                break;
            case "/":
                result = num1/num2;
                break;
        }
        return result;
    }
}