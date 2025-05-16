package CommonMethods;

import org.openqa.selenium.WebDriver;

public class RandomStrings {
     



	public static String requiredString(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(n);
        int y;
        for ( y = 0; y < n; y++)
        {
            int index = (int)(AlphaNumericString.length() * Math.random());
            s.append(AlphaNumericString.charAt(index));
        }
        return s.toString();

    }


    public static String requiredCharacters(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(n);
        int y;
        for (y = 0; y < n; y++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            s.append(AlphaNumericString.charAt(index));
        }
        return s.toString();
    }

    public static String requiredDigits(int n) {
        String AlphaNumericString = "1234567890";
        StringBuilder s = new StringBuilder(n);
        int y;
        for (y = 0; y < n; y++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            s.append(AlphaNumericString.charAt(index));
        }
        return s.toString();
    }
}
