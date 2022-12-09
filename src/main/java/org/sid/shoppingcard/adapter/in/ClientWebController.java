package org.sid.shoppingcard.adapter.in;

import java.util.ArrayList;

import org.sid.kernel.CommandBus;
import org.sid.kernel.QueryBus;
import org.sid.shoppingcard.application.port.in.CreateClientCommand;
import org.sid.shoppingcard.application.port.in.ListClientQuery;
import org.sid.shoppingcard.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clients")
@SuppressWarnings("all")
public class ClientWebController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private ClientWebController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateClientResponse create(@RequestBody @Valid CreateClientRequest createClientRequest) {
        var cartId = (String) commandBus
                .post(new CreateClientCommand(createClientRequest.firstName, createClientRequest.lastName));
        return new CreateClientResponse(cartId);
    }

    @GetMapping
    public GetClientResponse getAllClient() {
        var client = (ArrayList<Client>) queryBus.post(new ListClientQuery());
        return new GetClientResponse(client);
    }

}
