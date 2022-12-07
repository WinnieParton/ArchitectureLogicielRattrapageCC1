package org.sid.shoppingcard.application.services;

import java.util.List;

import org.sid.shoppingcard.application.port.in.GetAllCartUseCase;
import org.sid.shoppingcard.application.port.in.ListCartQuery;
import org.sid.shoppingcard.application.port.out.LoadCartPort;
import org.sid.shoppingcard.domain.Cart;

public final class GetAllCartService implements GetAllCartUseCase {

    private final LoadCartPort loadCartPort;

    public GetAllCartService(LoadCartPort loadCartPort) {
        this.loadCartPort = loadCartPort;
    }

    @Override
    public List<Cart> handle(ListCartQuery query) {
        var cart = loadCartPort.findAll();
        return cart;
    }

}
