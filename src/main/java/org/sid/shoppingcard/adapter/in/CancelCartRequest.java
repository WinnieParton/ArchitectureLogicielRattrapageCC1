package org.sid.shoppingcard.adapter.in;

import jakarta.validation.constraints.NotNull;

public class CancelCartRequest {
    @NotNull
    public String cartId;
}
