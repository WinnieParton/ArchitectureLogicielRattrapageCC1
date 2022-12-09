package org.sid.shoppingcard.application.services;

import java.util.List;

import org.sid.shoppingcard.application.port.in.GetAllClientUseCase;
import org.sid.shoppingcard.application.port.in.ListClientQuery;
import org.sid.shoppingcard.application.port.out.LoadClientPort;
import org.sid.shoppingcard.domain.Client;

public final class GetAllClientService implements GetAllClientUseCase {

    private final LoadClientPort clientPort;

    public GetAllClientService(LoadClientPort clientPort) {
        this.clientPort = clientPort;
    }

    @Override
    public List<Client> handle(ListClientQuery query) {
        var client = clientPort.findAllClient();
        return client;
    }

}
