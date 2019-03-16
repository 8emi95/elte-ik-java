// Csak pozitív kitevőt kezel.

class Power {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = 1;
        for (int i = 0; i < b; i++) {
            c = c * a;
        }
        System.out.println(c);
    }
}
