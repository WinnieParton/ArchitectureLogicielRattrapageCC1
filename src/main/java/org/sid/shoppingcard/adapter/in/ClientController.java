package org.sid.shoppingcard.adapter.in;

import java.util.List;

import org.sid.kernel.CommandBus;
import org.sid.kernel.QueryBus;
import org.sid.shoppingcard.application.port.in.CreateClientCommand;
import org.sid.shoppingcard.application.port.in.ListClientQuery;
import org.sid.shoppingcard.domain.Client;

public final class ClientController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public ClientController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public List<Client> getAllClient() {
        return (List<Client>) queryBus.post(new ListClientQuery());
    }

    public String createClient(String firstName, String lastName) {
        return (String) commandBus.post(new CreateClientCommand(firstName, lastName));
    }
}
