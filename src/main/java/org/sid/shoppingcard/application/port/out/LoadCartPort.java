package org.sid.shoppingcard.application.port.out;

import java.util.List;

import org.sid.shoppingcard.domain.Cart;

public interface LoadCartPort {
    List<Cart> findAll();
}
