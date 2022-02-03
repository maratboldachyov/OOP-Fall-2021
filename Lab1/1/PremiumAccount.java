import java.math.BigDecimal;

public class PremiumAccount extends Account{

    public PremiumAccount(String number, Client owner, BigDecimal balance) {
        super(number, owner, balance);
    }

    @Override
    public void credit(BigDecimal balance){
        super.balance = super.balance.add(balance);
    }

    @Override
    public void debit(BigDecimal balance){
            super.balance = super.balance.subtract(balance);
    }
}
