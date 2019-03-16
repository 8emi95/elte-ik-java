package financial;

import financial.bank.ATM;
import financial.person.Customer;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Simulator {

    private ATM atm;
    private List<Customer> customers = new LinkedList<>();
    private PrintWriter pwLog;

    public Simulator(String bankName, int initAmount, String outputFileName) throws IllegalArgumentException, FileNotFoundException {
        atm = ATM.makeATM(bankName, initAmount);

        customers.clear();

        File file = new File(outputFileName);
        pwLog = new PrintWriter(file);
    }

    private Customer getCustomerByName(String name) {
        Customer ret = null;
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                ret = c;
            }
        }
        return ret;
    }

    public void insertCustomer(String customerName, int birthYear, String bankName) {
        Customer temp = Customer.makeCustomer(customerName, birthYear, bankName);
        if (temp != null && getCustomerByName(customerName) == null) {
            customers.add(temp);
        }
    }

    public void withdrawCash(String customerName, int amount) {
        Customer tmp = getCustomerByName(customerName);
        if (amount > 0 && atm.getAmount() > amount && tmp != null) {
            int fee = atm.calculateFee(tmp.getBank(), amount);
            if (tmp.getAmount() > fee) {
                tmp.decreaseAmount(fee);
                atm.decreaseAmount(amount);
                pwLog.println(tmp.toString());
            }
        }
    }

    public void depositCash(String customerName, int amount) {
        Customer tmp = getCustomerByName(customerName);
        if (amount > 0 && atm.getAmount() > amount && tmp != null) {
            tmp.increaseAmount(amount);
            atm.increaseAmount(amount);
            pwLog.println(tmp.toString());
        }
    }

    public void simulate(String inputFileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(inputFileName));

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] splittedLine = str.split(":");

            if (splittedLine.length == 2) {
                switch (splittedLine[0]) {
                    case "REG":
                        String[] data = splittedLine[1].split(",");
                        if (data.length == 3) {
                            try {
                                insertCustomer(data[0], Integer.parseInt(data[1]), data[2]);
                            } catch (NumberFormatException e) {
                            }
                        }
                        break;
                    case "GET":
                        String[] datas = splittedLine[1].split(",");
                        if (datas.length == 2) {
                            String customerName = datas[0];
                            try {
                                int amount = Integer.parseInt(datas[1]);
                                withdrawCash(customerName, amount);
                            } catch (NumberFormatException e) {
                            }
                        }
                        break;
                    case "PUT":
                        String[] dat = splittedLine[1].split(",");
                        if (dat.length == 2) {
                            String customerName = dat[0];
                            try {
                                int amount = Integer.parseInt(dat[1]);
                                depositCash(customerName, amount);
                            } catch (NumberFormatException e) {
                            }
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
