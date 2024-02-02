import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ConverterRunner {

    public static boolean isBinary(String input)
    {
        return input.matches("[0-1]*$");
    }

    public static boolean isValidOctal( String octalInput )
    {
        return octalInput.matches( "[0-7]*$" );
    }

    public static boolean isValidDecimal(String input) {
        return input.matches("^[0-9]*$");
    }

    public static boolean isValidHex(String input) {
        return input.matches("^[0-9A-Fa-f]*$");
    }

    public static void main(String[] args) {
        boolean isBaseValid = false;
        boolean isNumberValid = false;
        int base = 0;
        int n = 0;
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");

        while (!isBaseValid) {
            System.out.print("Enter the base of your number (2, 8 or 10): ");
            String choice = s.nextLine();
            base = Integer.parseInt(choice);
            if (base == 2 || base == 8 || base == 10 || base == 16) {
                isBaseValid = true;
            } else {
                System.out.println("Please enter a valid base!");
            }
        }
        
        String number = null;
        while (!isNumberValid) {
            System.out.print("Enter your number: ");
            number = s.nextLine();
            if (base == 2 && isBinary(number)) {
                isNumberValid = true;
            }
            if (base == 8 && isValidOctal(number)) {
                isNumberValid = true;
            }
            if (base == 10 && isValidDecimal(number)) {
                isNumberValid = true;
            }
            if (base == 16 && isValidHex(number)) {
                isNumberValid = true;
            }
        }
        s.close();

        NumberConverter nc = new NumberConverter(number, base);
        String[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Original Number: " + nc.displayOriginalNumber());
        System.out.println("As decimal: " + Arrays.toString(nc.convertToDecimal()));
        System.out.println("As binary: " + Arrays.toString(nc.convertToBinary()));
        System.out.println("As octal: " + Arrays.toString(nc.convertToOctal()));


    }
}

