package cn.sxt.Exception;

/**
 * 测试自定义异常
 * */
class OverDraftException extends Exception{
    private double dicifit;

    public OverDraftException(double v) {
        this.dicifit = v;
    }

    public double getDicifit() {
        return dicifit;
    }
}

//账户类
public class Account {
    public double balance;
    public Account(){
    }

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    //取钱可能会余额不足，此时抛出一个自定义异常
    public void withdraw(double money) throws OverDraftException{
        if(this.balance<money){
            throw new OverDraftException(money-this.balance);
        }
        this.balance -= money;
    }

    public static void main(String[] args) {
        Account a = new Account(10000.0);

        //谁调用谁捕获
        try {
            a.withdraw(12000);
        }catch (OverDraftException e){
            System.out.println("余额不足：-"+e.getDicifit());
        }
    }
}
