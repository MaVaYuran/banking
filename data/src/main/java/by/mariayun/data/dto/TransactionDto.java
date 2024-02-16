package by.mariayun.data.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class TransactionDto implements Serializable {
    private int id;
    private Integer value;
    private Timestamp paydate;
    private int cardId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Timestamp getPaydate() {
        return paydate;
    }

    public void setPaydate(Timestamp paydate) {
        this.paydate = paydate;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
