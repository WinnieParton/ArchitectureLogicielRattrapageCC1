package org.sid.shoppingcard.application.port.in;

import org.sid.kernel.Command;

import jakarta.validation.constraints.NotNull;

public final class CreateClientCommand implements Command {

    @NotNull
    public final String firstName;

    @NotNull
    public final String lastName;

    public CreateClientCommand(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
