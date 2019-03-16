package main;

import financial.Simulator;

public class Main
{

    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Nem megfelelo szamu parameter");
            System.exit(1);
        }
        try {
            Simulator simulator = new Simulator(args[0],1000000,args[2]);
            simulator.simulate(args[1]);
            simulator.close();
        } catch (Exception e) {
            System.out.println(e + " kivetel keletkezett a futas soran. ");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
