import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * .
 * This class calculates the power of a number using recursion.
 * @author Tony Tran
 * @version 1.0
 * @since 2025-05-01
 */
final class RecPow {
    /**
     * This is a private constructor to satisfy style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecPow() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This function calculates the power of a base raised to an exponent
     * using recursion.
     * @param base the base number
     * @param exponent the exponent number
     * @return the result of base raised to the power of exponent
     */
    public static int recPower(final int base, final int exponent) {
        // Base case: any number raised to the power of 0 is 1
        if (exponent == 0) {
            return 1;
        }
        // If exponent is negative, calculate the power of the positive exponent
        // and return its reciprocal
        if (exponent < 0) {
            return 1 / recPower(base, -exponent);
        }
        // Recursive case: multiply base by the result of base raised to the
        // power of exponent - 1
        return base * recPower(base, exponent - 1);
    }

    /**
     * This the main method to run the program.
     * @param args
     */
    public static void main(final String[] args) throws Exception {
        // Create a Scanner object to read from the input file
        Scanner input = new Scanner(new File(args[0]));
        // Create a FileWriter object to write to the output file
        FileWriter writer = new FileWriter("output.txt");
        // Loop through space-separated integers in the input file
        while (input.hasNext()) {
            try {
                // Read the base and exponent from the input file
                int base = Integer.parseInt(input.next());
                int exponent = Integer.parseInt(input.next());

                // Calculate the power of the base raised to the exponent
                int result = recPower(base, exponent);

                // Write the result to the output file
                writer.write(base + " raised to the power of "
                        + exponent + " is " + result + "\n");
            } catch (NumberFormatException e) {
                // Write an error message to the output file
                writer.write("Error: Invalid input."
                 + "Please provide integers.\n");
            }
        }
        // Close the FileWriter and Scanner objects
        writer.close();
        input.close();
    }
}
