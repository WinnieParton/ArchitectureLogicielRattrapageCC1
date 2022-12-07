package org.sid.shoppingcard.domain;

import java.math.BigDecimal;

public final class Amount {

    private final BigDecimal amount;

    private Amount(BigDecimal amount) {
        this.amount = amount;
    }

    public static Amount of(double amount) {
        return new Amount(BigDecimal.valueOf(amount));
    }

    public Amount validate(Amount money) {
        return new Amount(amount.add(money.amount));
    }

    public double value() {
        return amount.doubleValue();
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
