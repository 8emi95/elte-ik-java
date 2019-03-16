import java.util.Arrays;

class Fibonacci {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] fibs = new int[n];
        if (n < 2) {
            for (int i = 0; i < n; i++)
                System.out.print(i + " ");
        } else {
            fibs[0] = 0;
            fibs[1] = 1;
            for (int i = 2; i < n; i++)
                fibs[i] = fibs[i - 1] + fibs[i - 2];
            System.out.print(Arrays.toString(fibs));
        }
        System.out.println();
    }
}
