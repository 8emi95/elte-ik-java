package financial;

import financial.bank.ATM;
import financial.person.Customer;

import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulator {
    private ATM atm;
    private List<Customer> customers = new ArrayList<>(50);
    private PrintWriter pwLog;

    public Simulator(String bankName, int initAmount, String outputFileName) throws IllegalArgumentException, FileNotFoundException {
        atm = ATM.makeATM(bankName, initAmount);
        customers.clear();
        pwLog = new PrintWriter(new File(outputFileName));
    }

    private Customer getCustomerByName(String name) {
        for (Customer c: customers) {
            if (name.equals(c.getName())) {
                return c;
            }
        }
        return null;
    }

    public void insertCustomer(String customerName, int birthYear, String bankName) {
        Customer c = Customer.makeCustomer(customerName, birthYear, bankName);
        if (c != null && getCustomerByName(customerName) == null) {
            customers.add(c);
        }
    }

    public void withdrawCash(String customerName, int amount) {
        Customer c = getCustomerByName(customerName);
        if (c != null && atm.getAmount() >= amount && amount > 0) {
            int fee = atm.calculateFee(c.getBank(), amount);
            if (c.getAmount() >= (fee + amount)) {
                atm.decreaseAmount(amount);
                c.decreaseAmount(amount + fee);
                pwLog.println(c.toString());
            }
        }
    }

    public void depositCash(String customerName, int amount) {
        Customer c = getCustomerByName(customerName);
        if (c != null && amount > 0) {
            atm.increaseAmount(amount);
            c.increaseAmount(amount);
            pwLog.println(c.toString());
        }
    }

    public void simulate(String inputFileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(inputFileName));

        while (sc.hasNextLine()) {
            String[] splittedLine = sc.nextLine().split(":");

            if (splittedLine.length == 2) {
                switch (splittedLine[0]) {
                    case "REG":
                        String[] splittedReg = splittedLine[1].split(",");
                        if (splittedReg.length == 3) {
                            try {
                                insertCustomer(splittedReg[0], Integer.parseInt(splittedReg[1]), splittedReg[2]);
                            } catch (NumberFormatException nfe) {}
                        }
                        break;
                    case "GET":
                        String[] splittedGet = splittedLine[1].split(",");
                        if (splittedGet.length == 2) {
                            try {
                                withdrawCash(splittedGet[0], Integer.parseInt(splittedGet[1]));
                            } catch (NumberFormatException nfe) {}
                        }
                        break;
                    case "PUT":
                        String[] splittedPut = splittedLine[1].split(",");
                        if (splittedPut.length == 2) {
                            try {
                                depositCash(splittedPut[0], Integer.parseInt(splittedPut[1]));
                            } catch (NumberFormatException nfe) {}
                        }
                        break;
                }
            }
        }
        sc.close();
    }

    public void close() {
        pwLog.close();
    }
}