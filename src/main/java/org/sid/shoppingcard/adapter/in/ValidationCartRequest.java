package org.sid.shoppingcard.adapter.in;

import jakarta.validation.constraints.NotNull;

public class ValidationCartRequest {
    @NotNull
    public long amount;
}
