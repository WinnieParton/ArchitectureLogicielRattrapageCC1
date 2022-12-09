package org.sid.shoppingcard.adapter.in;

import jakarta.validation.constraints.NotNull;

public class CreateClientRequest {
    @NotNull
    public String firstName;

    @NotNull
    public String lastName;
}
