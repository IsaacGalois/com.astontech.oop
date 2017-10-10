package common.helpers;

public class StringHelper extends CommonHelper {

    //notes:    this checks a string if it is null or empty returns TRUE, otherwise returns FALSE
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static String TitleCase(String input) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (i == 0 || input.charAt(i - 1) == ' ')
                output.append(Character.toUpperCase(input.charAt(i)));
            else
                output.append(input.charAt(i));
        }

        return output.toString();
    }

    public static boolean equalsCaseInsensistive(String a, String b) {

        return a.toUpperCase().equals(b.toUpperCase());
    }

    public static boolean validEmail(String email) {
        return(email.matches("^([a-zA-Z0-9_\\-]+)@([a-zA-Z0-9_\\-]+)\\.([a-zA-Z]{2,5})$"));
    }

}
