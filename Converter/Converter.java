package Converter;

public class Converter {

    public static WordList wordFormat = new WordList();

    public static final void converter(int value) {

        int valueSize = String.valueOf(value).length();

        String[] output = new String[valueSize];

        int outputSize = output.length;
        int tracker = 1;
        int commasCTR = 0;
        int preValHolder = 0;

        // Returns "Zero" if value = 0
        if (value == 0) {
            System.out.println("Zero");
            return;
        };

        // Self-made Conversion Method
        for (int valHolder = value, placeVal = 0; placeVal <= outputSize - 1; placeVal++, tracker++) {

            int remainder = valHolder % 10;
            int nextDigit = valHolder / 10 % 10;
            valHolder = valHolder / 10;
            // Num to Word Conditional Statements
            switch (tracker) {
                case 1: 
                    if (placeVal == 0) {
                        output[placeVal] = WordList.wordFormat[0][remainder]; // Ones
                    } else {
                        output[placeVal] = WordList.wordFormat[0][remainder].concat(" " + WordList.commas[commasCTR]); // Commas
                        commasCTR++;
                    }
                    break;
                case 2: 
                    if (remainder == 1) { // Teens
                        output[placeVal] = WordList.wordFormat[1][preValHolder + 1];
                        if (placeVal < 3) output[placeVal - 1] = " ";
                        else output[placeVal - 1] = WordList.commas[commasCTR - 1];
                    } else if (placeVal > 3 && preValHolder == 0 && remainder == 0 && nextDigit == 0) { // Comma Zero Value Handler
                        output[placeVal - 1] = " ";
                        output[placeVal] = WordList.wordFormat[2][remainder];
                    } else {
                        output[placeVal] = WordList.wordFormat[2][remainder]; // Decades
                    }
                    break;
                case 3: 
                    output[placeVal] = WordList.wordFormat[3][remainder]; // Hundredths
                    break;
            }
            // Re-assigning Values
            if (tracker == 3) tracker = 0;
            preValHolder = remainder;
        }
        for (int i = outputSize - 1; i >= 0; i--) {
            if (output[i] == " ") continue;
            System.out.print(output[i].trim() + " ");
        }
        return;
    }
}