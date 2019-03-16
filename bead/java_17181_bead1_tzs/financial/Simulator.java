package financial;

import financial.bank.ATM;
import financial.person.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulator {
    private ATM atm;
    private List<Customer> customers = new ArrayList<>(50);
    private PrintWriter pwLog;

    public Simulator(String bankName, int initAmount, String outputFileName) throws FileNotFoundException {
        atm = ATM.makeATM(bankName, initAmount);
        pwLog = new PrintWriter(outputFileName);
    }

    private Customer getCustomerByName(String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name)) return c;
        }
        return null;
    }

    public void insertCustomer(String customerName, int birthYear, String bankName) {
        Customer customer = Customer.makeCustomer(customerName, birthYear, bankName);
        if (customer != null && getCustomerByName(customerName) == null) customers.add(customer);
    }

    public void withdrawCash(String customerName, int amount) {
        Customer customer = getCustomerByName(customerName);

        if (customer != null && amount > 0) {
            int fee = atm.calculateFee(customer.getBank(), amount);
            if (atm.getAmount() >= amount && amount + fee <= customer.getAmount()) {
                atm.decreaseAmount(amount);
                customer.decreaseAmount(amount + fee);
                pwLog.println(customer.toString());
            }
        }
    }

    public void depositCash(String customerName, int amount) {
        Customer customer = getCustomerByName(customerName);
        if (customer != null && amount > 0) {
            atm.increaseAmount(amount);
            customer.increaseAmount(amount);
            pwLog.println(customer.toString());
        }
    }

    public void simulate(String inputFileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(inputFileName));
        while (sc.hasNextLine()) {
            try {
                String[] splittedLine = sc.nextLine().split(":");
                if (splittedLine.length == 2) {
                    switch (splittedLine[0]) {
                        case "REG": {
                            String[] customerDatas = splittedLine[1].split(",");
                            if (customerDatas.length == 3) {
                                try {
                                    insertCustomer(customerDatas[0], Integer.parseInt(customerDatas[1]), customerDatas[2]);
                                } catch (NumberFormatException e) {
                                }
                            }
                            break;
                        }
                        case "GET": {
                            String[] withdraw = splittedLine[1].split(",");
                            if (withdraw.length == 2) {
                                try {
                                    withdrawCash(withdraw[0], Integer.parseInt(withdraw[1]));
                                } catch (NumberFormatException e) {
                                }
                            }
                            break;
                        }
                        case "PUT": {
                            String[] deposit = splittedLine[1].split(",");
                            if (deposit.length == 2) {
                                try {
                                    depositCash(deposit[0], Integer.parseInt(deposit[1]));
                                } catch (NumberFormatException e) {
                                }
                            }
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        pwLog.close();
    }
}
