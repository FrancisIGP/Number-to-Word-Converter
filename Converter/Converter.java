package Converter;

public class Converter {

    public static WordList wordFormat = new WordList();

    public static final void converter(long value) {

        long valueSize = String.valueOf(value).length();

        String[] output = new String[(int) valueSize];

        long outputSize = output.length;
        long tracker = 1;
        long commasCTR = 0;
        long preValHolder = 0;

        // Returns "Zero" if value = 0
        if (value == 0) {
            System.out.println("Zero");
            return;
        };

        // Self-made Conversion Method
        for (long valHolder = value, placeVal = 0; placeVal <= outputSize - 1; placeVal++, tracker++) {

            long remainder = valHolder % 10;
            long nextDigit = valHolder / 10 % 10;
            valHolder = valHolder / 10;
            // Num to Word Conditional Statements
            switch ((int) tracker) {
                case 1: 
                    if (placeVal == 0) {
                        output[(int) placeVal] = WordList.wordFormat[0][(int) remainder]; // Ones
                    } else {
                        output[(int) placeVal] = WordList.wordFormat[0][(int) remainder].concat(" " + WordList.commas[(int) commasCTR]); // Commas
                        commasCTR++;
                    }
                    break;
                case 2: 
                    if (remainder == 1) { // Teens
                        output[(int) placeVal] = WordList.wordFormat[1][(int) preValHolder + 1];
                        if (placeVal < 3) output[(int) placeVal - 1] = " ";
                        else output[(int) placeVal - 1] = WordList.commas[(int) commasCTR - 1];
                    } else if (placeVal > 3 && preValHolder == 0 && remainder == 0 && nextDigit == 0) { // Comma Zero Value Handler
                        output[(int) placeVal - 1] = " ";
                        output[(int) placeVal] = WordList.wordFormat[2][(int) remainder];
                    } else {
                        output[(int) placeVal] = WordList.wordFormat[2][(int) remainder]; // Decades
                    }
                    break;
                case 3: 
                    output[(int) placeVal] = WordList.wordFormat[3][(int) remainder]; // Hundredths
                    break;
            }
            // Re-assigning Values
            if (tracker == 3) tracker = 0;
            preValHolder = remainder;
        }
        for (long i = outputSize - 1; i >= 0; i--) {
            if (output[(int) i] == " ") continue;
            System.out.print(output[(int) i].trim() + " ");
        }
        return;
    }
}