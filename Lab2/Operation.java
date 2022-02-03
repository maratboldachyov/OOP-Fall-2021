import java.math.BigDecimal;
import java.time.LocalDateTime;

public class operation extends Account {
    private String operationType;
    private BigDecimal amount;
    private LocalDateTime time;

    public operation(String operationType, BigDecimal amount, LocalDateTime time){
        this.operationType = operationType;
        this.amount = amount;
        this.time = time;
    }
    public String toString(){
        return this.operationType + " " + this.amount + " " + this.time;
    }
}
