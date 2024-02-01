import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ConverterRunner {

    static boolean isBinary(int number)
    {
        Set<Integer> set = new HashSet<>();

        // Put all the digits of the number in the set
        while (number > 0) {
            int digit = number % 10;
            set.add(digit);
            number /= 10;
        }

        // Since a HashSet does not allow duplicates so only
        // a single copy of '0' and '1' will be stored
        set.remove(0);
        set.remove(1);

        // If the original number only contained 0's and 1's
        // then size of the set must be 0
        if (set.size() == 0) {
            return true;
        }
        return false;
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
            if (base == 2 || base == 8 || base == 10) {
                isBaseValid = true;
            } else {
                System.out.println("Please enter a valid base!");
            }
        }

        while (!isNumberValid) {
            System.out.print("Enter your number: ");
            String number = s.nextLine();
            n = Integer.parseInt(number);
            if (base == 2 && isBinary(n)) {
                isNumberValid = true;
            }
            if (base == 8 && )
        }
        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        System.out.println("As decimal: " + Arrays.toString(nc.convertToDecimal()));
        System.out.println("As binary: " + Arrays.toString(nc.convertToBinary()));
        System.out.println("As octal: " + Arrays.toString(nc.convertToOctal()));


    }
}

