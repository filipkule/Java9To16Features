import com.service.RequiredClass;

public class JavaModularity {
    public static void main(String[] args) {
        System.out.print(printMessage());
    }

    public static String printMessage() {
        return RequiredClass.printMessage();
    }
}
