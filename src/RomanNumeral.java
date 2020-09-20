public class RomanNumeral {

    private final int num;

    private static int[]    numbers = {  10,    9,    5,    4,    1 };

    private static String[] letters = { "X",  "IX", "V",  "IV", "I" };

    public RomanNumeral(int arabic) {
        if (arabic < 1)
            throw new NumberFormatException("RomanNumeral must be positive.");

        num = arabic;
    }

    public RomanNumeral(String roman) {

        if (roman.length() == 0)
            throw new NumberFormatException("empty string");

        roman = roman.toUpperCase();

        int i = 0;
        int arabic = 0;

        while (i < roman.length()) {

            char letter = roman.charAt(i);
            int number = letterToNumber(letter);


            if (number < 0)
                throw new NumberFormatException("Illegal character \"" + letter );
            i++;

            if (i == roman.length()) {
                arabic += number;
            }
            else {

                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    arabic += (nextNumber - number);
                    i++;
                }
                else {
                    arabic += number;
                }
            }

        }

        if (arabic > 10)
            throw new NumberFormatException("Roman numeral must have value 10 or less.");

        num = arabic;

    }


    private int letterToNumber(char letter) {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            default:   return -1;
        }
    }


    public String toString() {
        String roman = "";
        int N = num;
        for (int i = 0; i < numbers.length; i++) {
            while (N >= numbers[i]) {
                roman += letters[i];
                N -= numbers[i];
            }
        }
        return roman;
    }

    public int toInt() {
        return num;
    }


}
