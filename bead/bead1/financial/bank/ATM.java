package financial.bank;

import financial.bank.Bank;

public class ATM {
    private Bank bank;
    private int amount;

    private ATM(Bank bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    public static ATM makeATM(String bankName, int amount) {
        try {
            Bank bank;
            bank = Bank.valueOf(bankName);

            if (amount > 0) {
                return new ATM(bank, amount);
            } else {
                return null;
            }
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public int getAmount() {
        return amount;
    }

    public void decreaseAmount(int value) {
        amount -= value;
    }

    public void increaseAmount(int value) {
        amount += value;
    }

    public int calculateFee(Bank bank, int value) {
        if (bank == this.bank) {
            return value > 20000 ? (int) Math.ceil(value*0.01) : 200;
        } else {
            return value > 50000 ? (int) Math.ceil(value*0.03) : 500;
        }
    }
}