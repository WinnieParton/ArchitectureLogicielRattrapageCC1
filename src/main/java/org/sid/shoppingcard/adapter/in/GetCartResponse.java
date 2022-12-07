package org.sid.shoppingcard.adapter.in;

import java.util.ArrayList;

import org.sid.shoppingcard.domain.Cart;

public class GetCartResponse {
    public final ArrayList<Cart> cart;

    public GetCartResponse(ArrayList<Cart> cart) {
        this.cart = cart;
    }
}
