package org.sid.shoppingcard.application.port.in;

import org.sid.kernel.Command;

import jakarta.validation.constraints.NotNull;

public final class ValidationCartCommand implements Command {

    @NotNull
    public final double initialAmount;

    public ValidationCartCommand(double initialAmount) {
        this.initialAmount = initialAmount;
    }
}
