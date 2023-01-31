import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatting {
    public static void main(String[] args) {
        NumberFormat compactNumberInstance = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        compactNumberInstance.setMinimumFractionDigits(3);
        compactNumberInstance.setMaximumFractionDigits(6);

        System.out.println("Format for 2095,2: " + compactNumberInstance.format(2095.2));
        System.out.println("Format for 2: " + compactNumberInstance.format(2));
        System.out.println("Format for 200: " + compactNumberInstance.format(200));
        System.out.println("Format for 2000: " + compactNumberInstance.format(2000));
        System.out.println("Format for 20000: " + compactNumberInstance.format(20000));
        System.out.println("Format for 589777,544888: " + compactNumberInstance.format(589777.544888));
    }
}
