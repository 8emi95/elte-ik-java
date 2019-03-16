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

            if (name.matches("[a-zA-Z\\s]+") && 
                !name.matches("\\s+{2,}") && 
                name.trim().split("\\s+").length >= 2 && 
                name.trim().split("\\s+").length <= 4 && 
                name.matches("^([A-Z]{1}[a-z]{2,} ){1,3}([A-Z]{1}[a-z]{2,})$") && 
                birthYear >= 1918 && 
                birthYear <= 1998) {
                return new Customer(name, birthYear, bank);
            } else {
                return null;
            }
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

    public void decreaseAmount(int value) {
        this.amount -= value;
    }

    public void increaseAmount(int value) {
        this.amount += value;
    }

    public String toString() {
        return getName() + ": " + getAmount();
    }
}