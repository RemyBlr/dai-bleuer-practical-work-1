package ch.heigvd;

public class ProcessFiles {
    public static String processFile(String input) {
        // Loop on all the parameters in the command line
        for (String operation : Commands.operations) {
            if (operation.equals("uppercase")) {
                input = input.toUpperCase();
            }
            else if (operation.equals("lowercase")) {
                input = input.toLowerCase();
            }
            else if (operation.equals("reverse")) {
                input = new StringBuilder(input).reverse().toString();
            }
            else if (operation.equals("alternate")) {
                // StringBuilder is used to concatenate strings
                StringBuilder sb = new StringBuilder();
                // Loop on the input string and alternate between upper and lower case
                for (int i = 0; i < input.length(); i++) {
                    if (i % 2 == 0) {
                        sb.append(Character.toUpperCase(input.charAt(i)));
                    } else {
                        sb.append(Character.toLowerCase(input.charAt(i)));
                    }
                }
                input = sb.toString();
            }
            else {
                throw new IllegalArgumentException("Invalid operation");
            }
        }
        return input;
    }
}
