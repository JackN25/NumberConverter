public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;

    }

    public int[] convertToDecimal() {
        int base10 = 0;
        for (int i = 0; i < digits.length; i++) {
            base10 += digits[i] * Math.pow(base, (digits.length - 1) - i);
        }
        String base10AsString = "" + base10;

        int [] base10InArray = new int[base10AsString.length()];
        for (int i = 0; i < base10AsString.length(); i++) {
            String singleDigit = base10AsString.substring(i,i+1);
            int d = Integer.parseInt(singleDigit);
            base10InArray[i] = d;
        }
        return base10InArray;
    }

    public int[] convertToBinary() {
        if (base != 10) {
            int[] base10inArray = convertToDecimal();
            int base10 = 0;
            for (int digit : base10inArray) {

            }
        }
        return null;
    }

    public int[] convertToOctal() {
        return null;
    }
}

