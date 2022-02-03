import java.math.BigDecimal;

public class PremiumAcc extends Account {
    public PremiumAcc(String number, String status, Client owner, BigDecimal balance){

    }

    void credit(BigDecimal balance){
        balance=balance.add(balance);
    }

    void debit(BigDecimal balance){
        BigDecimal newBalance = balance.subtract(balance);
    }

    void paymentForService(){
        balance = balance.subtract(new BigDecimal("2050.00"));
    }

    @Override
    protected String balanceBuilder() {
        return "ok";
    }
    void getStatement(){

    }
}
