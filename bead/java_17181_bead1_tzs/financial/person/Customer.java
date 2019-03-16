package financial.person;

import financial.bank.Bank;

public class Customer
{
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
        Bank bank;
        if (!name.matches("^([A-Z][a-z]{2,} ){1,3}([A-Z][a-z]{2,})$")) {
            return null;
        }
        if (birthYear < 1918 || birthYear > 1998) {
            return null;
        }
        try {
            bank = Bank.valueOf(bankName);
        } catch (IllegalArgumentException e) {
            return null;
        }

        return new Customer(name, birthYear, bank);
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

    public void decreaseAmount(int value) {
        this.amount -= value;
    }

    public void increaseAmount(int value) {
        this.amount += value;
    }

    public String toString() {
        return this.name + ": " + this.amount;
    }
}
