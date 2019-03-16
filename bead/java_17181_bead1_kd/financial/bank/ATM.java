package financial.bank;

public class ATM {

    private Bank bank;
    private int amount;

    private ATM(Bank bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    public static ATM makeATM(String bankName, int amount) {
        boolean b = false;
        Bank bank = Bank.valueOf(bankName);
        if (bank == Bank.valueOf(bankName)) {
            b = true;
        }

        if (amount > 0 && b == true) {
            return new ATM(Bank.valueOf(bankName), amount);
        }
        return null;
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

    public int calculateFee(Bank bank, int value) {
        double personalPercent = Math.ceil(value * 0.01);
        double foreignPercent = Math.ceil(value * 0.03);

        if (this.bank == bank) {
            if (personalPercent < 200) {
                personalPercent = 200;
            }
            value += personalPercent;

        } else {
            if (foreignPercent < 500) {
                foreignPercent = 500;
            }
            value += foreignPercent;
        }
        return value;
    }

}
