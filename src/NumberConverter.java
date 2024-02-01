public class NumberConverter {
    int[] digits;
    int firstBase;
    int base10;
    int binary;
    int octal;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.firstBase = base;
        if (base == 10) {
            base10 = number;
            calculateBinary();
            calculateOctal();
        } else if (base == 2) {
            binary = number;
            calculateBase10();
            calculateOctal();
        } else if (base == 8) {
            octal = number;
            calculateBase10();
            calculateBinary();
        } else if (base == 16) {

        }

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

    private void calculateBase10() {
        for (int i = 0; i < digits.length; i++) {
            base10 += digits[i] * Math.pow(firstBase, (digits.length - 1) - i);
        }
    }

    public int[] convertToDecimal() {
        String base10AsString = "" + base10;

        int [] base10InArray = new int[base10AsString.length()];
        for (int i = 0; i < base10AsString.length(); i++) {
            String singleDigit = base10AsString.substring(i,i+1);
            int d = Integer.parseInt(singleDigit);
            base10InArray[i] = d;
        }
        return base10InArray;
    }

    private void calculateBinary(){
        String binaryString = "";
        int base10ForCalculation = base10;
        while (base10ForCalculation != 1) {
            if (base10ForCalculation % 2 != 0) {
                binaryString += "1";
                base10ForCalculation -= 1;
                base10ForCalculation /= 2;
            } else {
                binaryString += "0";
                base10ForCalculation /= 2;
            }
        }
        binary = Integer.parseInt(binaryString);
    }

    public int[] convertToBinary() {
        String binaryAsString = Integer.toString(binary);
        int[] binaryArray = new int[binaryAsString.length()];
        for (int i = 0; i < binaryArray.length; i++) {
            binaryArray[i] = Integer.parseInt(binaryAsString.charAt(i) + "");
        }
        return binaryArray;
    }

    private void calculateOctal() {
        String octalString = "";
        int base10ForCalculation = base10;
        while (base10ForCalculation != 0) {
            if (base10ForCalculation % 8 == 0) {
                octalString += "0";
                base10ForCalculation /= 8;
            } else {
                octalString += (base10ForCalculation % 8) + "";
                base10ForCalculation -= (base10ForCalculation % 8);
                base10ForCalculation /= 8;
            }
        }
        octal = Integer.parseInt(octalString);
    }

    public int[] convertToOctal() {
        String octalAsString = Integer.toString(octal);
        int[] octalArray = new int[octalAsString.length()];
        for (int i = 0; i < octalArray.length; i++) {
            octalArray[i] = Integer.parseInt(octalAsString.charAt(i) + "");

        }
        return octalArray;
    }
}

