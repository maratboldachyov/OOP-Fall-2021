import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Account {
    protected String AccNumber;
    protected String status;
    protected Client ownerName;
    protected BigDecimal balance;
    protected ArrayList<operation> operations;

    public BankAcc(String accNumber,String status, String ownerName, BigDecimal balance){

    }
    String getNumber(){
        return AccNumber;
    }
    String getStatus(){
        return status;
    }

    Client getOwner(){
        return ownerName;
    }

    BigDecimal getBalance(){
        return balance;
    }

    void setStatus(String status){
        this.status = status;
    }

    protected String balanceBuilder(){
        return ;
    }

    void credit(BigDecimal balance){
        balance = balance.add(balance);
    }

    void debit(BigDecimal balance){
        BigDecimal newBalance = balance.subtract(balance);
    }

    void paymentForService(){
        balance = balance.subtract(new BigDecimal("2000.00"));
    }

    void getStatement(){

    }
}
