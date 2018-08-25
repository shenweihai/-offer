import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 1, 1)));
        System.out.println("Hello World!");
        System.out.println(0.1 * 2 == 0.2);
        System.out.println(1.01 + 2.02);
        short i = 0;
        double x = 1;
        i = (short) x;
        x = i;
    }
}
