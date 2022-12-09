package org.sid.shoppingcard.application.port.out;

import org.sid.shoppingcard.domain.Client;
import org.sid.shoppingcard.domain.ClientId;


public interface CreateClientPort {
    ClientId nextIdClient();

    void saveClient(Client client);

}
