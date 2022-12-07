package org.sid.shoppingcard.application.port.out;

import org.sid.shoppingcard.domain.Cart;
import org.sid.shoppingcard.domain.CartId;

public interface CancelCartStatePort {
    void update(Cart cart);

    Cart findById(CartId cartId);
}
