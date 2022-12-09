package org.sid.shoppingcard.application.port.out;

import java.util.List;

import org.sid.shoppingcard.domain.Client;

public interface LoadClientPort {
    List<Client> findAllClient();
}
