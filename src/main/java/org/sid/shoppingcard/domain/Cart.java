package org.sid.shoppingcard.domain;

import java.util.Date;
import java.util.Objects;

public final class Cart {

    private final CartId cartId;
    private Amount amount;
    private Statut statut;
    private Date date;

    public Cart(CartId cartId, Amount amount, Date date, Statut statut) {
        this.cartId = cartId;
        this.amount = amount;
        this.statut = statut;
        this.date = date;
    }

    public Amount amount() {
        return amount;
    }

    public CartId getCartId() {
        return cartId;
    }

    public Amount getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId);

    }

    @Override
    public String toString() {
        return "{cartId: " + cartId.value() + ", amount: " + amount.value()
                + ", statut: " + statut + ", date: " + date + "}";
    }

}
