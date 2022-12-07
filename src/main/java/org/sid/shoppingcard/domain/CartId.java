package org.sid.shoppingcard.domain;

import java.util.Objects;
import java.util.UUID;

public final class CartId {

    private final UUID value;

    private CartId(UUID value) {
        this.value = value;
    }

    public static CartId of(UUID value) {
        return new CartId(value);
    }

    public String value() {
        return value.toString();
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CartId cartId = (CartId) o;
        return Objects.equals(value, cartId.value);
    }

    @Override
    public String toString() {
        return "CartId {value:'" + value + '\'' + '}';
    }

    public UUID getValue() {
        return value;
    }

}
