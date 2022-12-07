package org.sid.shoppingcard.application.port.out;

import org.sid.shoppingcard.domain.Cart;
import org.sid.shoppingcard.domain.CartId;

public interface ValidationCartPort {
    CartId nextId();

    void save(Cart cart);
}
