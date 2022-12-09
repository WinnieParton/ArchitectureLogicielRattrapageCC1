package org.sid.shoppingcard.application.port.in;

import org.sid.kernel.Command;

import jakarta.validation.constraints.NotNull;

public final class ValidationCartCommand implements Command {

    @NotNull
    public final double initialAmount;

    public final String clientId;

    public ValidationCartCommand(double initialAmount, String clientId) {
        this.initialAmount = initialAmount;
        this.clientId = clientId;
    }
}
