package org.sid.shoppingcard.application.port.out;

import org.sid.shoppingcard.domain.Cart;
import org.sid.shoppingcard.domain.CartId;
import org.sid.shoppingcard.domain.Client;
import org.sid.shoppingcard.domain.ClientId;


public interface ValidationCartPort {
    CartId nextId();

    void save(Cart cart);

    Client findById(ClientId clientId);

}
