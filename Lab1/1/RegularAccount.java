import java.math.BigDecimal;

public class RegularAccount extends Account{

    public RegularAccount(String number, Client owner, BigDecimal balance){
        super(number,owner, balance);

    }

    @Override
    public void credit(BigDecimal balance){
        if(balance.compareTo(new BigDecimal("10000")) > 0){
            System.out.println("Request canceled, regular account can credit only 10000 dollars");
        }
        else
            super.balance = super.balance.add(balance);
    }

    @Override
    public void debit(BigDecimal balance){
        if(balance.compareTo(new BigDecimal("100000")) > 0){
            System.out.println("Request canceled, regular account can debit only 100000 dollars");
        }
        else
            super.balance = super.balance.subtract(balance);
    }
}
