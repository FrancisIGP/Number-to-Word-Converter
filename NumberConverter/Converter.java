package NumberConverter;

public class Converter 
{

    public static wordList format = new wordList();

    public static final void converter(String value) 
    {

        int valueSize = String.valueOf(value).length();

        char[] charArr = value.toCharArray();
        String[] output = new String[valueSize];

        int outputSize = output.length;
        int tracker = 1;
        int commasCTR = 1;
        int nextDigit = 0;
        int preValHolder = 0;

        // Returns "Zero" if value = 0
        if (charArr[valueSize - 1] - '0' == 0 && valueSize == 1) 
        {
            System.out.println("Zero");
            return;
        };

        // Self-made Conversion Method
        for (int placeVal = 0, ctr = valueSize; placeVal <= outputSize - 1; placeVal++, tracker++, ctr--) 
        {

            // Assignment of Variables
            int currentVal = charArr[ctr - 1] - '0';

            if (placeVal > 0 && placeVal < outputSize - 1) 
            {
                preValHolder = charArr[(ctr - 1) + 1] - '0'; 
                nextDigit = charArr[(ctr - 1 - 1)] - '0';
            } 

            // Num to Word Conditional Statements
            switch (tracker) 
            {
                case 1:
                    if (placeVal == 0) 
                    {
                        output[placeVal] = format.wordFormat[0][currentVal]; // Ones 
                    } else
                    {
                        output[placeVal] = format.wordFormat[0][currentVal].concat(" " + format.commas[commasCTR]); // Commas
                        commasCTR++;
                    }
                    break;
                case 2:
                    if (currentVal == 1) // Teens
                    { 
                        output[placeVal] = format.wordFormat[1][preValHolder + 1];
                        if (placeVal < 3) output[placeVal - 1] = " ";
                        else output[placeVal - 1] = format.commas[commasCTR - 1];
                    } else if (placeVal > 3 && preValHolder == 0 && currentVal == 0 && nextDigit == 0) // Comma Zero Value Handler
                    {
                        output[placeVal] = format.wordFormat[2][currentVal];
                        output[placeVal - 1] = " ";
                    } else 
                    {
                        output[placeVal] = format.wordFormat[2][currentVal]; // Decades
                    }
                    break;
                case 3:
                    if (currentVal == 0) output[placeVal] = " "; 
                    else output[placeVal] = format.wordFormat[0][currentVal].concat(" " + format.commas[0]); // Hundredths
                    break;
            }
            // Re-assigning and Resetting Variables
            if (tracker == 3) tracker = 0;
        }
        for (int printOutput = outputSize - 1; printOutput >= 0; printOutput--) 
        {
            if (output[printOutput] == " ")
                continue;
            System.out.print(output[printOutput].trim() + " ");
        }
        return;
    }
}