package org.sid.shoppingcard.domain;

public class CartException extends RuntimeException {

    private CartException(String message) {
        super(message);
    }

    public static CartException notFoundCartId(CartId cartId) {
        return new CartException(String.format("%s not found.", cartId.value()));
    }
}
