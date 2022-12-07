package org.sid.shoppingcard.adapter.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.sid.shoppingcard.application.port.out.CancelCartStatePort;
import org.sid.shoppingcard.application.port.out.LoadCartPort;
import org.sid.shoppingcard.application.port.out.ValidationCartPort;
import org.sid.shoppingcard.domain.Cart;
import org.sid.shoppingcard.domain.CartException;
import org.sid.shoppingcard.domain.CartId;

public class CartPersistenceAdapter implements LoadCartPort, CancelCartStatePort, ValidationCartPort {

    private final Map<CartId, Cart> registry = new HashMap<>();

    @Override
    public CartId nextId() {
        return CartId.of(UUID.randomUUID());
    }

    @Override
    public void save(Cart cart) {
        registry.put(cart.getCartId(), cart);
    }

    @Override
    public void update(Cart cart) {
        registry.put(cart.getCartId(), cart);
    }

    @Override
    public ArrayList<Cart> findAll() {
        return new ArrayList<Cart>(registry.values());
    }

    @Override
    public Cart findById(CartId cartId) {
        return registry.computeIfAbsent(cartId,
                key -> {
                    throw CartException.notFoundCartId(cartId);
                });
    }
}