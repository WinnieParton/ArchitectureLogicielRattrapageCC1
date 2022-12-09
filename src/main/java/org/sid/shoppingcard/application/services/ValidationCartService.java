package org.sid.shoppingcard.application.services;

import java.util.Date;
import java.util.UUID;

import org.sid.shoppingcard.application.port.in.ValidationCartCommand;
import org.sid.shoppingcard.application.port.in.ValidationCartUseCase;
import org.sid.shoppingcard.application.port.out.ValidationCartPort;
import org.sid.shoppingcard.domain.Cart;
import org.sid.shoppingcard.domain.ClientId;
import org.sid.shoppingcard.domain.Statut;
import org.sid.shoppingcard.domain.Amount;

public final class ValidationCartService implements ValidationCartUseCase {

    private final ValidationCartPort createCartPort;

    public ValidationCartService(ValidationCartPort createCartPort) {
        this.createCartPort = createCartPort;
    }

    @Override
    public String handle(ValidationCartCommand command) {
        var cartId = createCartPort.nextId();
        var client = createCartPort.findById(ClientId.of(UUID.fromString(command.clientId)));
        var cart = new Cart(cartId, Amount.of(command.initialAmount), new Date(), Statut.Valider, client);
        createCartPort.save(cart);
        return cartId.value();
    }
}
