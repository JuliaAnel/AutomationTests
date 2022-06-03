import org.apache.commons.lang3.StringUtils;

public class Main {

    public static String abbr(String str, int size) {
        return str.substring(0, size - 3) + "...";
    }


    public static void main(String[] args) {

        System.out.println(StringUtils.abbreviate("Julia", 4));
        System.out.println(abbr("Julia", 4));
        System.out.println(StringUtils.substring("Hello", 3));
    }

    public static int[] reverse(int n) {
        int[] arr = new int[n];
        if (n > 0) {
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = n;
                n--;
            }
        }
        return arr;
    }
}
