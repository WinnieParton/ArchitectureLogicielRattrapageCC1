package org.sid.shoppingcard.adapter.in;

import java.util.ArrayList;

import org.sid.kernel.CommandBus;
import org.sid.kernel.QueryBus;
import org.sid.shoppingcard.application.port.in.CancelCartCommand;
import org.sid.shoppingcard.application.port.in.ListCartQuery;
import org.sid.shoppingcard.application.port.in.ValidationCartCommand;
import org.sid.shoppingcard.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carts")
@SuppressWarnings("all")
public class CartWebController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private CartWebController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ValidationCartResponse create(@RequestBody @Valid ValidationCartRequest createCartRequest) {
        var cartId = (String) commandBus.post(new ValidationCartCommand(createCartRequest.amount, createCartRequest.clientId));
        return new ValidationCartResponse(cartId);
    }

    @GetMapping
    public GetCartResponse getAllCart() {
        var cart = (ArrayList<Cart>) queryBus.post(new ListCartQuery());
        return new GetCartResponse(cart);
    }

    @PostMapping(value = "/cancel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CancelCartResponse cancel(@RequestBody @Valid CancelCartRequest cancelCartRequest) {
        var cartId = (String) commandBus.post(new CancelCartCommand(cancelCartRequest.cartId));
        return new CancelCartResponse(cartId);
    }
}
