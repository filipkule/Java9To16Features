public class Java14DescriptiveNullPointerException {
    public static void main(String[] args) {
        try {
            System.out.println(invokeNPE());
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }
    }

    public static String invokeNPE() throws NullPointerException{
        String[] list = null;
        list[0] = "Hello Stranger!";

        return list[0];
    }
}
