class IntOps {
    public static void main(String[] args) {
        System.out.println("Kerek ket egesz szamot!");
        int a = Integer.parseInt(System.console().readLine());
        int b = Integer.parseInt(System.console().readLine());
        System.out.println(a + " * " + b + " = " + a * b);
        if (b != 0) {
           System.out.println(a + " / " + b + " = " + a / b);
           System.out.println(a + " % " + b + " = " + a % b);
           System.out.println(a + " = " + b + " * " + a / b + " + " + a % b);
        }
    }
}
