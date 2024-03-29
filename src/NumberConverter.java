public class NumberConverter {
    int[] digits;
    String[] base16digits;
    int firstBase;
    int base10;
    int binary;
    int octal;
    String hex = "";

    public NumberConverter(String number, int base) {
        this.firstBase = base;
        if (base != 16) {
            digits = new int[number.length()];
            for (int i = 0; i < number.length(); i++) {
                String single = number.substring(i, i + 1);
                int d = Integer.parseInt(single);
                digits[i] = d;
            }
            if (base == 10) {
                base10 = Integer.parseInt(number);
                calculateBinary();
                calculateOctal();
                calculateHex();
            } else if (base == 2) {
                binary = Integer.parseInt(number);
                calculateBase10();
                calculateOctal();
                calculateHex();
            } else if (base == 8) {
                octal = Integer.parseInt(number);
                calculateBase10();
                calculateBinary();
                calculateHex();
            }
        } else {
            base16digits = new String[number.length()];
            for (int i = 0; i < number.length(); i++) {
                base16digits[i] = number.charAt(i) + "";
            }
            String base10String = "";
            for (int i = 0; i < number.length(); i++) {
                String c = number.charAt(i) + "";
                if (Character.isDigit(c.charAt(0))) {
                    base10String += c + " ";
                }
                if (c.equalsIgnoreCase("a")) {
                    base10String += 10 + " ";
                }
                if (c.equalsIgnoreCase("b")) {
                    base10String += 11 + " ";
                }
                if (c.equalsIgnoreCase("c")) {
                    base10String += 12 + " ";
                }
                if (c.equalsIgnoreCase("d")) {
                    base10String += 13 + " ";
                }
                if (c.equalsIgnoreCase("e")) {
                    base10String += 14 + " ";
                }
                if (c.equalsIgnoreCase("f")) {
                    base10String += 15 + " ";
                }
            }
            String [] base10StringArray = base10String.split(" ");
            for (int i = 0; i < base10StringArray.length; i++) {
                base10 += (int) (Integer.parseInt(base10StringArray[i]) * Math.pow(16, (base10StringArray.length - 1) - i));
            }
            calculateBinary();
            calculateOctal();
            hex = number;
        }
    }

    public String displayOriginalNumber() {
        String o = "";
        if (firstBase != 16) {
            for (int digit : digits) {
                o = o + digit;
            }
            o = o + "\n";
        } else {
            for (String base16digit : base16digits) {
                o += base16digit;
            }
            o += "\n";
        }
        return o;
    }

    public String[] getDigits() {
        if (firstBase != 16) {
            String [] digitsString = new String[digits.length];
            for (int i = 0; i < digits.length; i++) {
                digitsString[i] = Integer.toString(digits[i]);
            }
            return digitsString;
        } else {
            return base16digits;
        }

    }

    private void calculateBase10() {
        for (int i = 0; i < digits.length; i++) {
            base10 += (int) (digits[i] * Math.pow(firstBase, (digits.length - 1) - i));
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
        if (base10ForCalculation % 2 == 0) {
            binaryString += "10";
            base10ForCalculation /= 2;
        }
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
                octalString = "0" + octalString;
                base10ForCalculation /= 8;
            } else {
                octalString = ((base10ForCalculation % 8) + "") + octalString;
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
    
    private void calculateHex() {
        int base10ForCalculation = base10;
        while (base10ForCalculation != 0) {
            if (base10ForCalculation % 16 == 0) {
                base10ForCalculation /= 16;
                hex = "0" + hex;
            } else if (base10ForCalculation % 16 <= 9) {
                hex = (base10ForCalculation % 16) + hex;
                base10ForCalculation -= base10ForCalculation % 16;
                base10ForCalculation /= 16;
            } else if (base10ForCalculation % 16 == 10) {
                hex = "a" + hex;
                base10ForCalculation -= base10ForCalculation % 16;
                base10ForCalculation /= 16;
            } else if (base10ForCalculation % 16 == 11) {
                hex = "b" + hex;
                base10ForCalculation -= base10ForCalculation % 16;
                base10ForCalculation /= 16;
            } else if (base10ForCalculation % 16 == 12) {
                hex = "c" + hex;
                base10ForCalculation -= base10ForCalculation % 16;
                base10ForCalculation /= 16;
            } else if (base10ForCalculation % 16 == 13) {
                hex = "d" + hex;
                base10ForCalculation -= base10ForCalculation % 16;
                base10ForCalculation /= 16;
            } else if (base10ForCalculation % 16 == 14) {
                hex = "e" + hex;
                base10ForCalculation -= base10ForCalculation % 16;
                base10ForCalculation /= 16;
            } else {
                hex = "f" + hex;
                base10ForCalculation -= base10ForCalculation % 16;
                base10ForCalculation /= 16;
            }
        }
    }

    public String convertToHex() {
        return hex;
    }

    public String convertDecimalToBase(int base) {
        int decimalNumber = base10;
        if (base == 0) {
            return "0";
        }
        if (decimalNumber == 0) {
            return "0";
        }
        if (base == 1) {
            StringBuilder result = new StringBuilder();
            while (decimalNumber != 0) {
                result.insert(0, "1");
                decimalNumber -= 1;
            }
            return result.toString();
        }
        StringBuilder result = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            result.insert(0, getBaseCharacter(remainder));
            decimalNumber /= base;
        }
        return result.toString();
    }

    private static char getBaseCharacter(int value) {
        if (value >= 0 && value <= 9) {
            return (char) ('0' + value);
        } else if (value >= 10 && value <= 35) {
            return (char) ('A' + (value - 10));
        } else if (value >= 36 && value <= 61) {
            return (char) ('a' + (value - 36));
        } else if (value == 62) {
            return '+';
        } else if (value == 63) {
            return '/';
        } else {
            throw new IllegalArgumentException("Invalid base character for value: " + value);
        }
    }
}