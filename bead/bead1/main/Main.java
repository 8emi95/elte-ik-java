package main;

import java.util.Scanner;
import java.io.File;

import financial.Simulator;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Nem megfelelo szamu parameter.");
            System.exit(1);
        }
        try {
            Simulator s = new Simulator(args[0], 1000000, args[2]);
            s.simulate(args[1]);
            s.close();
        } catch (Exception e) {
            System.out.println("Kivetel keletkezett a futas soran: " + e);
            System.exit(1);
        }
    }
}