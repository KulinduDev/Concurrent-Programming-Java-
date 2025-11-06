import java.math.BigDecimal;

public class Husband implements Runnable{ //implements Runnable to define work

    private BankAccount account;

    public Husband (BankAccount b1){
        this.account = b1;
    }

    @Override
    public void run(){
        for(int i = 0;i<10;i++){
            account.withdraw(new BigDecimal (25000.00));
            try{
                Thread.sleep(300);
            }catch(Exception e){
                e.printStackTrace();

                // try and catch block pauses the current thread for 300 milliseconds and prints and error if the pause is interrupted

            }
        }
    }
}
