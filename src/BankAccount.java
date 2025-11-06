import java.math.BigDecimal;

public class BankAccount {

    private String AcctName;
    private BigDecimal balance;

    public BankAccount(String AcctName , BigDecimal balance){
        this.AcctName =AcctName;
        this.balance  = balance;
    }

    public void setAcctName(String AcctName){
        this.AcctName = AcctName;
    }

    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }

    public String getAcctName(){
        return AcctName;
    }

    public synchronized BigDecimal getBalance(){ // synchronized is used to protect shared data being corrupted by multiple threads accessing it at the same time
        return balance;
    }


    public synchronized void withdraw(BigDecimal amount){

        // only positive withdrawals make sense
        if(amount.doubleValue() <= 0){
           System.out.println(Thread.currentThread().getName() + " tried invalid withdrawal amount: " + amount);
           return;
        }

        //check sufficient funds
        if (balance.compareTo(amount)>=0){
            //BigDecimal is immutable! assign the result back
            balance = balance.subtract(amount);
            System.out.println(Thread.currentThread().getName() + " withdraws " + amount + " | New Balance: " + balance);

        }else{
            System.out.println(Thread.currentThread().getName() + " Tried to withdraw " + amount + " but insufficient available funds. Balance: " + balance);

        }

    }

    // deposit money in a thread safe way
    public synchronized void deposit(BigDecimal amount){
        if (amount.doubleValue()>0){
            // big decimal is immutable so assign the result back
            balance = balance.add(amount);
            System.out.println(Thread.currentThread().getName() + " deposits " + amount + " | New Balance: " + balance );

        }else{
            System.out.println(Thread.currentThread().getName() + " tried to deposit invalid amount: " + amount);

        }
    }

}
