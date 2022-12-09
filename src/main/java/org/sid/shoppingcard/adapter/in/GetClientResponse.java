package org.sid.shoppingcard.adapter.in;

import java.util.ArrayList;

import org.sid.shoppingcard.domain.Client;

public class GetClientResponse {
    public final ArrayList<Client> clients;

    public GetClientResponse(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
