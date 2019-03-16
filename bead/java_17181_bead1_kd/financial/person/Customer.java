package financial.person;

import financial.bank.Bank;

public class Customer {

    private String name;
    private int birthYear;
    private Bank bank;
    private int amount;

    private Customer(String name, int birthYear, Bank bank) {
        this.name = name;
        this.birthYear = birthYear;
        this.bank = bank;
        this.amount = 0;
    }

    public static Customer makeCustomer(String name, int birthYear, String bankName) {
        try {
            Bank bank;
            bank = Bank.valueOf(bankName);

            String[] splittedName = name.split(" ");
            if (splittedName.length > 1 && splittedName.length < 5) {
                for (int i = 0; i < splittedName.length; ++i) {
                    if (!splittedName[i].matches("[A-Z]{1}[a-z]{2,}")) {
                        return null;
                    }
                }
                if (1918 > birthYear || birthYear > 1998) {
                    return null;
                }
                return new Customer(name, birthYear, bank);
            }
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public String getName() {
        return this.name;
    }

    public Bank getBank() {
        return this.bank;
    }

    public int getAmount() {
        return this.amount;
    }

    public void decreaseAmount(int val) {
        amount -= val;
    }

    public void increaseAmount(int value) {
        amount += value;
    }

    public String toString() {
        return this.name + ": " + this.amount;
    }
}
