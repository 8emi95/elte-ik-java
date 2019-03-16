package financial.bank;

public class ATM {
    private Bank bank;
    private int amount;

    private ATM(Bank bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    public static ATM makeATM(String bankName, int amount) {
        try {
            Bank validBank = Bank.valueOf(bankName);
            if (amount > 0) {
                return new ATM(validBank, amount);
            }
            return null;
        } catch (Exception e) {
            //System.out.println(e);
            return null;
        }
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

    public int calculateFee(Bank bank, int value) {
        if (bank == this.bank) {
            return (int) Math.ceil(value * 0.01) > 200 ? (int) Math.ceil(value * 0.01) : 200;
        } else {
            return (int) Math.ceil(value * 0.03) > 500 ? (int) Math.ceil(value * 0.03) : 500;
        }
    }
}
