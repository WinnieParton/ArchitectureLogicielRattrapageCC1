package org.sid.shoppingcard.adapter.in;

import java.util.List;

import org.sid.kernel.CommandBus;
import org.sid.kernel.QueryBus;
import org.sid.shoppingcard.application.port.in.CancelCartCommand;
import org.sid.shoppingcard.application.port.in.ListCartQuery;
import org.sid.shoppingcard.application.port.in.ValidationCartCommand;
import org.sid.shoppingcard.domain.Cart;

public final class CartController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public CartController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public String validation(double initialAmount, String clientId) {
        return (String) commandBus.post(new ValidationCartCommand(initialAmount, clientId));
    }

    public String cancel(String cardId) {
        return (String) commandBus.post(new CancelCartCommand(cardId));
    }

    public List<Cart> getAllCart() {
        return (List<Cart>) queryBus.post(new ListCartQuery());
    }
}
