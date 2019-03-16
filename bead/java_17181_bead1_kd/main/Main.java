package main;

import financial.Simulator;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        if (args.length == 3) {
            try {
                Simulator object = new Simulator(args[0], 1000000, args[2]);

                try {
                    object.simulate(args[1]);
                    object.close();
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }

            } catch (Exception e) {
                System.out.println("Error: There has been an exception, when creating the object!");
            }
        } else {
            System.out.println("Error: There are not adequate number of parameters!");
        }
    }
}
