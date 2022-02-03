import java.math.BigDecimal;

public class GoldenAccount extends Account{

    public GoldenAccount(String number, Client owner, BigDecimal balance){
        super(number,owner, balance);

    }

    @Override
    public void credit(BigDecimal balance){
        if(balance.compareTo(new BigDecimal("100000")) > 0){
            System.out.println("Request canceled, golden account can credit only 100000 dollars");
        }
        else
            super.balance = super.balance.add(balance);
    }

    @Override
    public void debit(BigDecimal balance){
        if(balance.compareTo(new BigDecimal("1000000")) > 0){
            System.out.println("Request canceled, golden account can debit only 1000000 dollars");
        }
        else
            super.balance = super.balance.subtract(balance);
    }
}
