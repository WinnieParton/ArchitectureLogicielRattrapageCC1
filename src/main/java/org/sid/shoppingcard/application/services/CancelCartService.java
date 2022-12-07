package org.sid.shoppingcard.application.services;

import java.util.UUID;

import org.sid.shoppingcard.application.port.in.CancelCartCommand;
import org.sid.shoppingcard.application.port.in.CancelCartUseCase;
import org.sid.shoppingcard.application.port.out.CancelCartStatePort;
import org.sid.shoppingcard.domain.CartId;
import org.sid.shoppingcard.domain.Statut;

public final class CancelCartService implements CancelCartUseCase {

    private final CancelCartStatePort cancelCartStatePort;

    public CancelCartService(CancelCartStatePort cancelCartStatePort) {
        this.cancelCartStatePort = cancelCartStatePort;
    }

    @Override
    public String handle(CancelCartCommand command) {
        var cart = cancelCartStatePort.findById(CartId.of(UUID.fromString(command.cartId)));
        cart.setStatut(Statut.Annuler);
        cancelCartStatePort.update(cart);
        return "Annulation reussi !!";
    }
}
