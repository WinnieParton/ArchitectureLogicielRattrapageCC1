package org.sid.shoppingcard.application.port.out;

import java.util.List;

import org.sid.shoppingcard.domain.Cart;
import org.sid.shoppingcard.domain.CartId;

public interface CartRepository {

    CartId nextId();

    Cart findById(CartId cartId);

    void save(Cart cart);

    void update(Cart cart);

    List<Cart> findAll();
}
