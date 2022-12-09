package org.sid.shoppingcard.application.services;

import org.sid.shoppingcard.application.port.in.CreateClientCommand;
import org.sid.shoppingcard.application.port.in.CreateClientUseCase;
import org.sid.shoppingcard.application.port.out.CreateClientPort;
import org.sid.shoppingcard.domain.Client;

public final class CreateClientService implements CreateClientUseCase {

    private final CreateClientPort createClientPort;

    public CreateClientService(CreateClientPort createClientPort) {
        this.createClientPort = createClientPort;
    }

    @Override
    public String handle(CreateClientCommand command) {
        var clientId = createClientPort.nextIdClient();
        var client = new Client(clientId, command.firstName, command.lastName);
        createClientPort.saveClient(client);
        return clientId.getValue().toString();
    }
}
