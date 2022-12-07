package org.sid.shoppingcard.application.port.in;

import org.sid.kernel.Command;

import jakarta.validation.constraints.NotNull;

public final class CancelCartCommand implements Command {

    @NotNull
    public final String cartId;

    public CancelCartCommand(String cartId) {
        this.cartId = cartId;
    }
}
